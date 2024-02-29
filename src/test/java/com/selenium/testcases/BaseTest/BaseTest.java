package com.selenium.testcases.BaseTest;

import com.selenium.pageobjects.GlobalSQAPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.selenium.actiondriver.Action;
import com.selenium.base.BaseClass;
import com.selenium.pageobjects.BingPage;
import com.selenium.pageobjects.SearchResultPage;
import com.selenium.pageobjects.AdobeConverterPage;
import org.testng.annotations.Listeners;

@Listeners(com.selenium.base.TestListenerClass.class)
// Base test which will be extended by every new test class
public class BaseTest extends BaseClass {
	// Adding all pageObjects, so every class which extends current will have possibility to use methods from PO
	protected Action action = new Action();
	protected BingPage bingPage = new BingPage();
	protected SearchResultPage searchResultPage = new SearchResultPage();
	protected AdobeConverterPage adobeConverterPage = new AdobeConverterPage();
	protected GlobalSQAPage globalSQAPage = new GlobalSQAPage();
	
	// Setup webDriver
	@BeforeClass
	public void DefaultSetup() {
		SetUpApplication();
	}
	
	// Quit from webDriver
	@AfterClass
	public void DefaultTearDown() {
		QuitApplication();
	}
}
