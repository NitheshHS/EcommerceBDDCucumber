package com.ecommerce.baseutils;

import org.openqa.selenium.WebDriver;

import com.ecommerce.pageobjects.HomePage;
import com.ecommerce.pageobjects.PageObjectManager;
import com.ecommerce.pageobjects.ShopPage;

public class Base {
	
	public WebDriver driver;
	public FileUtility fUtil;
	public WebDriverUtility webUtility;
	public HomePage homePage;
	public ShopPage shopPage;
	public PageObjectManager pageObjManager;
}
