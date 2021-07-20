package com.ecommerce.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private ShopPage shopPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage initHomePage() {
		return (homePage==null)?homePage=new HomePage(driver):homePage;
	}
	
	public ShopPage initShopPage() {
		return (shopPage==null)?shopPage=new ShopPage(driver):shopPage;
	}

}
