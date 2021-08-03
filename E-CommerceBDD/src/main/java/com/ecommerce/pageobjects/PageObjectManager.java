package com.ecommerce.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private static WebDriver driver;
	private static HomePage homePage;
	private static ShopPage shopPage;
	
	
	
	public static HomePage initHomePage() {
		return (homePage==null)?homePage=new HomePage(driver):homePage;
	}
	
	public static ShopPage initShopPage() {
		return (shopPage==null)?shopPage=new ShopPage(driver):shopPage;
	}

}
