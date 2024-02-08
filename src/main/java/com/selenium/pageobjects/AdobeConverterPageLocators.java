package com.selenium.pageobjects;

import org.openqa.selenium.By;

interface AdobeConverterPageLocators {

    By DcConverterWidget = By.xpath("//div[@data-test-id='dropzone-footer-block']");
    By fileInput = By.id("fileInput");

    By downloadButton = By.xpath("//button[text()='Download']");

    static By QuestionList(int listIndex) {
        String questionListLocator =
                String.format("//dl[@id='accordion-1']//button[@id='accordion-1-trigger-%d']", listIndex);
        return By.xpath(questionListLocator);
    }

    static By QuestionListAnswer(int listIndex) {
        String questionListAnswerLocator =
                String.format("//dl[@id='accordion-1']//dd[@id='accordion-1-content-%d']", listIndex);
        return By.xpath(questionListAnswerLocator);
    }

    By SelectFileButton = By.id("lifecycle-nativebutton");
}
