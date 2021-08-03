package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ecommerce.baseutils.Base;
import com.ecommerce.pageobjects.HomePage;
import com.ecommerce.pageobjects.PageObjectManager;
import com.ecommerce.pageobjects.ShopPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopTest {
	Base base;
	public ShopTest(Base base) {
		this.base = base;
	}
	
	WebElement slider2;
	@Given("enter the URL {string}")
	public void enter_the_url(String url) {
		base.driver.get(url);
	}
	    
	@Given("click on Shop Menu")
	public void click_on_shop_menu() {
		base.homePage=PageObjectManager.initHomePage();
		base.homePage.getShopLink().click();
	}
	@When("Shop page is displayed i will go on price slider")
	public void shop_page_is_displayed_i_will_go_on_price_slider() {
	  base.shopPage=base.pageObjManager.initShopPage();
	  base.webUtility.hanldeSlider(base.driver, base.shopPage.getRightSlider(), 120, 0);
	}
	@When("Adjust the slider {int} to {int}")
	public void adjust_the_slider_to(Integer int1, Integer int2) {
	   String perMoved= base.shopPage.getRightSlider().getAttribute("style");
	   System.out.println("slider adjust: "+perMoved);
	}
	@When("Click on filter button")
	public void click_on_filter_button() {
	   base.shopPage.getFilterButton().click();
	}
	@Then("verify the product price between {int} to {int} or not")
	public void verify_the_product_price_between_to_or_not(Integer int1, Integer int2) {
	   List<WebElement> eBooks = base.shopPage.getBookNames();
	   
	   for(int i=0;i<eBooks.size();i++) {
		   System.out.println("Book Name: "+eBooks.get(i).getText());
	   }
	}

	@When("Home is displayed click on shop")
	public void home_is_displayed_click_on_shop() {
	    base.homePage=base.pageObjManager.initHomePage();
	    base.homePage.getShopLink().click();
	}
	@When("select default sorting dropdown and select {string}")
	public void select_default_sorting_dropdown_and_select(String visibleText) {
	    base.shopPage=base.pageObjManager.initShopPage();
	    base.webUtility.selectDropdown(base.shopPage.getOrderByDropdowm(), visibleText);
	}
	@Then("get all the book name and print in console")
	public void get_all_the_book_name_and_print_in_console() {
	 List<WebElement> books=  base.shopPage.getBookNames();
	 for(int i=0;i<books.size();i++) {
		 System.out.println(books.get(i).getText());
	 }
	}

}
