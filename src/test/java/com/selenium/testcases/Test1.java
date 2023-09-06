package com.selenium.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Step;
import utility.Logs;

public class Test1 extends BaseTest {
	// TestData
	String bingURL = "https://www.bing.com";
	String searchText = "weather in Lviv";
	String expectedText = "Lviv";
	String expectedText2 = "L'viv";
	String expectedText3 = "Львів";
	
	
  @Step("FirstTest")
  @Test
  public void FirstTest() {  
	  // Navigate to bing page
	  action.NavigateTo(bingURL);
	  Logs.Info("Navigated to Bing");
	  
	  // Execute search by provided text
	  bingPage.TypeSearchText(searchText, false);
	  bingPage.ClickOnSearchIcon();
	  Logs.Info("Executed search");	  
	  
	  // Verify that all search results contains Lviv in title
	  List<String> resultsOnUI = searchResultPage.GetSearchResultsTitles();
	  resultsOnUI.forEach(result -> {
		  Assert.assertTrue(result.contains(expectedText) || result.contains(expectedText2) || result.contains(expectedText3), result);
	  });
  }
}
