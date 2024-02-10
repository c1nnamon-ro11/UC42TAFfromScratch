package com.selenium.actiondriver;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
		wait.until(ExpectedConditions.elementToBeClickable(webElementLocator));
	}

	public void WaitForElementToBeVisible(By webElementLocator, int timeStamp){
		WebDriverWait wait = new WebDriverWait(GetDriver(), Duration.ofSeconds(timeStamp));
		wait.until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
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

	public void ClearField(By webElementLocator){
		WebElement webElement = GetDriver().findElement(webElementLocator);
		webElement.clear();
	}

	public String GetElementText(By webElementLocator) {
		WebElement webElement = GetDriver().findElement(webElementLocator);
		return webElement.getText();
	}

	public List<String> GetElementsText(By webElementsLocator){
		List<String> elementsText = new ArrayList<>();
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

	public void RightClick(By webElementLocator){
		WebElement webElement = GetDriver().findElement(webElementLocator);
		new Actions(GetDriver())
				.contextClick(webElement)
				.perform();
	}

	public void PressKey(Keys key){
		new Actions(GetDriver())
				.sendKeys(key)
				.perform();
	}

	public void RefreshPage(){
		GetDriver().navigate().refresh();
	}

	public void ClickAndHold(By webElementLocator){
		WebElement webElement = GetDriver().findElement(webElementLocator);
		new Actions(GetDriver())
				.clickAndHold(webElement)
				.perform();
	}

	public void DoubleClick(By webElementLocator){
		WebElement webElement = GetDriver().findElement(webElementLocator);
		new Actions(GetDriver())
				.doubleClick(webElement)
				.perform();
	}

	public void DragAndDropItem(By draggableWebElementLocator, By droppableWebElementLocator){
		WebElement draggableWebElement = GetDriver().findElement(draggableWebElementLocator);
		WebElement droppableWebElement = GetDriver().findElement(droppableWebElementLocator);

		new Actions(GetDriver())
				.dragAndDrop(draggableWebElement, droppableWebElement)
				.perform();
	}

	public void HoverMouse(By hoverableWebElementLocator){
		WebElement hoverableWebElement = GetDriver().findElement(hoverableWebElementLocator);
		new Actions(GetDriver())
				.moveToElement(hoverableWebElement)
				.perform();
	}

	public void CustomScrollToElement(By webElementLocator){
		WebElement webElement = GetDriver().findElement(webElementLocator);
		new Actions(GetDriver())
				.scrollToElement(webElement)
				.perform();
	}

	public void UploadFile(By webElementLocatorToUpload, String filePathToUpload){
		WebElement webElement = GetDriver().findElement(webElementLocatorToUpload);
		webElement.sendKeys(filePathToUpload);
	}

	public String GetAttributeValue(By webElementLocator, String attributeName){
		WebElement webElement = GetDriver().findElement(webElementLocator);
		return webElement.getAttribute(attributeName);
	}

	public String GetCSSValue(By webElementLocator, String CSSValue){
		WebElement webElement = GetDriver().findElement(webElementLocator);
		return webElement.getCssValue(CSSValue);
	}

	public boolean IsElementDisplayed(By webElementLocator){
		WebElement webElement = GetDriver().findElement(webElementLocator);
		return webElement.isDisplayed();
	}

	public void ScrollToElement(By webElementLocator){
		WebElement webElement = GetDriver().findElement(webElementLocator);
		new Actions(GetDriver())
				.moveToElement(webElement)
				.perform();
	}

	public boolean IsElementPresentAfterWait(By webElementLocator, int timeStamp){
		WebDriverWait wait = new WebDriverWait(GetDriver(), Duration.ofSeconds(timeStamp));
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	public void SwitchToIFrame(By iFrameLocator){
		WebElement iFrame = GetDriver().findElement(iFrameLocator);
		GetDriver().switchTo().frame(iFrame);
	}

	public void LeaveIFrame(){
		GetDriver().switchTo().defaultContent();
	}
}
