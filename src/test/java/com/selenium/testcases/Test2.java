package com.selenium.testcases;

import org.testng.annotations.Test;

import io.qameta.allure.Step;
import utility.Logs;

public class Test2 extends BaseTest {
	// TestData
	String bingURL = "https://www.bing.com";
  
  @Step("SecondTest")
  @Test
  public void SecondTest() {  
	  // Navigate to bing page
	  action.NavigateTo(bingURL);
	  Logs.Info("Navigated to Bing");
	  
	  // Execute search by provided text
	  bingPage.ClickOnChatLinkIcon();
	  Logs.Info("Open chatlink page");
	  
	  // Confused which popup has to be verified (or it even not appears)
	  action.JustWait(10000);	
  }
}
