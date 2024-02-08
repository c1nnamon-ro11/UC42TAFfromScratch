package com.selenium.pageobjects;

import org.openqa.selenium.By;

interface BingPageLocators {
	By searchField = By.id("sb_form_q");
	By SearchIcon = By.cssSelector("#search_icon > svg");
	By ChatLinkIcon = By.cssSelector("#codex > a");
	By HamburgerMenu = By.id("id_sc");
	By HamburgerMenuSettings = By.id("hbsettings");
	By MenuSettingsMore = By.xpath("//div[text()='Інші']/../..");
}
