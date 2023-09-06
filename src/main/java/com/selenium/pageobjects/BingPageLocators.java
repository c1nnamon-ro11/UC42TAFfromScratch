package com.selenium.pageobjects;

import org.openqa.selenium.By;

public interface BingPageLocators {		
	public By searchField = By.id("sb_form_q");
	public By SearchIcon = By.cssSelector("#search_icon > svg");
	public By ChatLinkIcon = By.cssSelector("#codex > a");
	public By HamburgerMenu = By.id("id_sc");
	public By HamburgerMenuSettings = By.id("hbsettings");
	public By MenuSettingsMore = By.xpath("//div[text()='Інші']/../..");
}
