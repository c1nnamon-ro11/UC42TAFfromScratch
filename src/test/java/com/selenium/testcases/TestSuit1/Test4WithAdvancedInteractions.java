package com.selenium.testcases.TestSuit1;

import com.selenium.testcases.BaseTest.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.Logs;

public class Test4WithAdvancedInteractions extends BaseTest {

    // Test data
    private final String ADOBE_URL = "https://www.adobe.com/ua/acrobat/online/pdf-to-word.html";

    @BeforeClass
    public void OneTimeSetup(){
        // Navigate to bing page
        action.NavigateTo(ADOBE_URL);
        Logs.Info("Navigated to Adobe");
    }

    @BeforeMethod
    public void Setup(){
        adobeConverterPage.WaitForPageToLoad();
    }

    @Step("Pressing TAB")
    @Test
    public void PressingTAB() {
        final int EXPECTED_LIST_ITEM_TO_BE_HIGHLIGHTED = 1;
        final int EXPECTED_LIST_ITEM_TO_NOT_BE_HIGHLIGHTED = 2;
        final int EXPECTED_NUMBER_OF_TABS = 18;

        // Pressing Tab till expected item will be selected
        for(int i = 0; i <= EXPECTED_NUMBER_OF_TABS; i++){
            action.JustWait(50);
            action.PressKey(Keys.TAB);
        }

        // Verify that expected item selected
        Assert.assertTrue(adobeConverterPage.IsQuestionListHighlighted(EXPECTED_LIST_ITEM_TO_BE_HIGHLIGHTED));
        Assert.assertFalse(adobeConverterPage.IsQuestionListHighlighted(EXPECTED_LIST_ITEM_TO_NOT_BE_HIGHLIGHTED));
    }

    @Step("Refreshing page")
    @Test
    public void RefreshingPage() {
        final int EXPECTED_LIST_ITEM = 1;
        Assert.assertTrue(adobeConverterPage.IsQuestionListAnswerHidden(EXPECTED_LIST_ITEM));

        // Open list item
        adobeConverterPage.OpenListAnswer(EXPECTED_LIST_ITEM);
        Assert.assertFalse(adobeConverterPage.IsQuestionListAnswerHidden(EXPECTED_LIST_ITEM));

        // Refresh page by pressing key
        action.RefreshPage();
        adobeConverterPage.WaitForPageToLoad();

        // Verify that item again hidden
        Assert.assertTrue(adobeConverterPage.IsQuestionListAnswerHidden(EXPECTED_LIST_ITEM));
    }

    @Step("Uploading document from system")
    @Test
    public void UploadingDocumentFromSystem(){
        String RELATIVE_PATH = "/src/test/resources/TestData/TestUploading.pdf";
        String workingDirectory = System.getProperty("user.dir");

        adobeConverterPage.UploadFileFromSystem(workingDirectory + RELATIVE_PATH);
        Assert.assertTrue(adobeConverterPage.IsFileReadyToBeDownloaded());
    }

    @Step("Hover Mouse On Button")
    @Test
    public void HoverMouseOnButton(){
        String DEFAULT_BUTTON_BACKGROUND_COLOR = "rgba(2, 101, 220, 1)";
        String HOVERED_BUTTON_BACKGROUND_COLOR = "rgba(0, 84, 183, 1)";

        Assert.assertEquals(adobeConverterPage.GetSelectFileButtonBackgroundColor(), DEFAULT_BUTTON_BACKGROUND_COLOR);
        // Hover and verify color again
        adobeConverterPage.HoverOnSelectFileButton();
        Assert.assertEquals(adobeConverterPage.GetSelectFileButtonBackgroundColor(), HOVERED_BUTTON_BACKGROUND_COLOR);
    }
}
