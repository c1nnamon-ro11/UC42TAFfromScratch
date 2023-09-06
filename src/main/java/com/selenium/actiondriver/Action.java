package com.selenium.actiondriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.base.BaseClass;

// Class with default abstract methods, which will be extended in POs
public class Action extends BaseClass {
	
	public void NavigateTo(String URL) {
		GetDriver().navigate().to(URL);	
	}
	
	public String GetCurrentPageURL() {
		return GetDriver().getCurrentUrl();
	}
	
	public void WaitForElementClickable(By webElementLocator, int timeStamp) {
		WebDriverWait wait = new WebDriverWait(GetDriver(), Duration.ofSeconds(timeStamp));
		wait.until(ExpectedConditions.elementToBeClickable(webElementLocator));;	
	}
	
	public void Click(By webElementLocator) {
		WaitForElementClickable(webElementLocator, 20);
		WebElement webElement = GetDriver().findElement(webElementLocator);
		webElement.click();
	}
	
	public void TypeText(By webElementLocator, String text, boolean clearText) {
		WebElement webElement = GetDriver().findElement(webElementLocator);
		if(clearText) {
			webElement.clear();
		}	
		webElement.sendKeys(text);
	}
	
	public String GetElementText(By webElementLocator) {
		WebElement webElement = GetDriver().findElement(webElementLocator);
		return webElement.getText();
	}
	
	public List<String> GetElementsText(By webElementsLocator){
		List<String> elementsText = new ArrayList<String>();
		List<WebElement> webElements = GetDriver().findElements(webElementsLocator);
		
		for(WebElement element : webElements) {
			elementsText.add(element.getText());
		}
		return elementsText;
	}
	
	public void JustWait(long timeStamp) {
		try {
			Thread.sleep(timeStamp);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
