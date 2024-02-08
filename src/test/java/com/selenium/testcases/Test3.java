package com.selenium.testcases;

import com.selenium.testcases.BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Step;
import utility.Logs;

public class Test3 extends BaseTest {
	// TestData
	String bingURL = "https://www.bing.com";
	String expectedPageURL = "https://www.bing.com/account/general?ru=https%3a%2f%2fwww.bing.com%2f&FORM=O2HV65";
	
  @Step("ThirdTest")
  @Test
  public void ThirdTest() {  
	  // Navigate to bing page
	  action.NavigateTo(bingURL);
	  Logs.Info("Navigated to Bing");
	  
	  // Open settings page
	  bingPage.OpenMoreSetingsPage();
	  Logs.Info("Open settings page");
	  
	  // Verify that opened page - settings page
	  String currentPageURL = action.GetCurrentPageURL();
	  Assert.assertEquals(currentPageURL, expectedPageURL, "Page URL is not as expected");
  }
}
