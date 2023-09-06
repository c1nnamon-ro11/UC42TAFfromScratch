package com.selenium.pageobjects;

import com.selenium.actiondriver.Action;

public class BingPage {
	Action action = new Action();
	
	public void TypeSearchText(String text, boolean clearData) {
		action.TypeText(BingPageLocators.searchField, text, clearData);
	}
	
	public void ClickOnSearchIcon() {
		action.Click(BingPageLocators.SearchIcon);
	}	
	
	public void ClickOnChatLinkIcon() {
		action.Click(BingPageLocators.ChatLinkIcon);
	}
	
	public void ClickOnHamburgerMenu() {
		
		action.Click(BingPageLocators.HamburgerMenu);
	}
	
	public void ClickOnSettingsOption() {
		action.Click(BingPageLocators.HamburgerMenuSettings);
	}
	
	public void ClickOnMoreOption() {
		action.Click(BingPageLocators.MenuSettingsMore);
	}
	
	public void OpenMoreSetingsPage() {
		ClickOnHamburgerMenu();
		ClickOnSettingsOption();
		ClickOnMoreOption();
	}
}
