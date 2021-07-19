package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ecommerce.baseutils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopTest {
	Base base;
	WebElement slider2;
	public ShopTest(Base base) {
		this.base = base;
	}

	@Given("enter the URL {string}")
	public void enter_the_url(String url) {
		base.driver.get(url);
	}
	    
	@Given("click on Shop Menu")
	public void click_on_shop_menu() {
	    base.driver.findElement(By.linkText("Shop")).click();
	}
	@When("Shop page is displayed i will go on price slider")
	public void shop_page_is_displayed_i_will_go_on_price_slider() {
	   slider2= base.driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-state-default ui-corner-all'][2]"));
	   Actions act=new Actions(base.driver) ;
	   act.clickAndHold(slider2).moveByOffset(120, 0).release().build().perform();
	}
	@When("Adjust the slider {int} to {int}")
	public void adjust_the_slider_to(Integer int1, Integer int2) {
	   String perMoved= slider2.getAttribute("style");
	   System.out.println("slider adjust: "+perMoved);
	}
	@When("Click on filter button")
	public void click_on_filter_button() {
	   base.driver.findElement(By.xpath("//button[text()='Filter']")).click();
	}
	@Then("verify the product price between {int} to {int} or not")
	public void verify_the_product_price_between_to_or_not(Integer int1, Integer int2) {
	   List<WebElement> eBooks = base.driver.findElements(By.tagName("h3"));
	   List<WebElement> price=base.driver.findElements(By.xpath("//span[@class='woocommerce-Price-amount amount']"));
	   for(int i=0;i<eBooks.size();i++) {
		   System.out.println("Book Name: "+eBooks.get(i).getText()+
				   "\t"+"price: "+price.get(i).getText());
	   }
	}

}
