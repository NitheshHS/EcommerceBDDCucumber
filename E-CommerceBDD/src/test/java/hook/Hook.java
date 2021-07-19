package hook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ecommerce.baseutils.Base;
import com.ecommerce.baseutils.FileUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook {
	Base base;
	public Hook(Base base) {
		this.base=base;
	}
	
	@Before
	public void setUp() throws Throwable{
		base.fUtil=new FileUtility();
		String browser=base.fUtil.getKeyValue("browser");
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
	}

	@After
	public void tearDown() {
		base.driver.quit();
	}

	
}
