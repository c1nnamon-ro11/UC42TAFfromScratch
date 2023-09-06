package com.selenium.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.selenium.actiondriver.Action;
import com.selenium.base.BaseClass;
import com.selenium.pageobjects.BingPage;
import com.selenium.pageobjects.SearchResultPage;

// Base test which will be extended by every new test class
public class BaseTest extends BaseClass {
	// Adding all pageObjects, so every class which extends current will have possibility to use methods from PO
	Action action = new Action();
	BingPage bingPage = new BingPage();
	SearchResultPage searchResultPage = new SearchResultPage();
	
	// Setup webDriver
	@BeforeClass
	public void Setup() {
		SetUpApplication();
	}
	
	// Quit from webDriver
	@AfterClass
	public void TearDown() {
		QuitApplication();
	}
}
