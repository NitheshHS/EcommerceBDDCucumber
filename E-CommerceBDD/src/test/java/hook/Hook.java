package hook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ecommerce.baseutils.Base;
import com.ecommerce.baseutils.FileUtility;
import com.ecommerce.baseutils.WebDriverUtility;
import com.ecommerce.pageobjects.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook {
	Base base;
	public Hook(Base base) {
		this.base=base;
	}
	
	@Before
	public void setUp() throws Throwable{
		base.fUtil=new FileUtility();
		base.webUtility=new WebDriverUtility();
		String browser=base.fUtil.getKeyValue("browser");
		//String browser=System.getProperty("BROWSER");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//base.pageObjManager=new PageObjectManager(base.driver);
	}

	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = base.webUtility.takeScreenshot(base.driver);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		base.driver.quit();
	}

	
}
