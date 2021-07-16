package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	String username="nitheshdemo@gmail.com";
	@Given("As a user I will launch browser")
	public void as_a_user_i_will_launch_browser() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("Enter the url")
	public void enter_the_url() {
	    driver.get("http://practice.automationtesting.in/");
	}
	@Given("click on myAccount")
	public void click_on_my_account() {
	    driver.findElement(By.linkText("My Account")).click();
	    
	}
	@When("login page is dispalyed I will enter username and password")
	public void login_page_is_dispalyed_i_will_enter_username_and_password() {
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys("Nithesh@0405");
	}

	@When("Click on login")
	public void click_on_login() {
	    driver.findElement(By.name("login")).click();
	}

	@Then("I will verify the username is present or not")
	public void i_will_verify_the_username_is_present_or_not() {
	   String actualusername= driver.findElement(By.xpath("//strong[text()]")).getText();
	   Assert.assertTrue(username.contains(actualusername));
	}

	@Then("Signout from the application")
	public void signout_from_the_application() {
	    driver.findElement(By.linkText("Sign out")).click();
	    driver.close();
	}
	
	@When("login page is displayed I will enter valid username {string} and enter invalid password {string}")
	public void login_page_is_displayed_i_will_enter_valid_username_and_enter_invalid_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys(password);
	}
	@Then("verify that error message is displaying or not")
	public void verify_that_error_message_is_displaying_or_not() {
	  String errorMsg=  driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li[text()]")).getText();
	  Assert.assertTrue(errorMsg.contains("ERROR"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
