package com.selenium.pageobjects;

import java.util.List;

import com.selenium.actiondriver.Action;

public class SearchResultPage implements SearchResultPageLocators{
	Action action = new Action();
	
	public List<String> GetSearchResultsTitles() {
		return action.GetElementsText(SearchResultPageLocators.SearchResults);
	}
}
