package com.selenium.pageobjects;

import com.selenium.actiondriver.Action;

public class AdobeConverterPage {
    Action action = new Action();

    public void WaitForPageToLoad(){
        action.WaitForElementToBeVisible(AdobeConverterPageLocators.DcConverterWidget, 20);
    }

    public boolean IsQuestionListHighlighted(int listItemIndex){
        String classValue = action.GetAttributeValue(AdobeConverterPageLocators.QuestionList(listItemIndex),"class");
        return classValue.contains("focus-ring");
    }

    public boolean IsQuestionListAnswerHidden(int listItemIndex){
        action.WaitForElementClickable(AdobeConverterPageLocators.QuestionList(listItemIndex), 5);
        return !action.IsElementDisplayed(AdobeConverterPageLocators.QuestionListAnswer(listItemIndex));
    }

    public void OpenListAnswer(int listItemIndex){
        action.Click(AdobeConverterPageLocators.QuestionList(listItemIndex));
    }

    public void UploadFileFromSystem(String filePath){
        action.UploadFile(AdobeConverterPageLocators.fileInput, filePath);
    }

    public boolean IsFileReadyToBeDownloaded(){
        return action.IsElementPresentAfterWait(AdobeConverterPageLocators.downloadButton,30);
    }

    public void HoverOnSelectFileButton(){
        action.HoverMouse(AdobeConverterPageLocators.SelectFileButton);
    }

    public String GetSelectFileButtonBackgroundColor(){
        return action.GetCSSValue(AdobeConverterPageLocators.SelectFileButton, "background-color");
    }
}
