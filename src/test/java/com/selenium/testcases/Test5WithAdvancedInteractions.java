package com.selenium.testcases;

import com.selenium.testcases.BaseTest.BaseTest;
import io.qameta.allure.Step;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test5WithAdvancedInteractions extends BaseTest {

    // Test data
    private final String GLOBAL_SQA = "https://www.globalsqa.com/demo-site/draganddrop/";

    @BeforeClass
    public void Setup(){
        action.NavigateTo(GLOBAL_SQA);
    }

    @Step("Drag and Drop")
    @Test
    public void DragAndDropAction() {
        int TEST_ITEM_INDEX = 1;
        int TEST_ITEM_INDEX_2 = 3;

        globalSQAPage.WaitForPageToLoad();
        globalSQAPage.SwitchToIframe();
        // Verify that items presented in default container
        Assert.assertTrue(globalSQAPage.IsItemPresentInDefaultList(TEST_ITEM_INDEX));
        Assert.assertTrue(globalSQAPage.IsItemPresentInDefaultList(TEST_ITEM_INDEX_2));

        // Execute action
        globalSQAPage.MoveItemToTrashBin(TEST_ITEM_INDEX);

        // Verify that only expected item was moved to trash bin
        Assert.assertTrue(globalSQAPage.IsItemPresentInTrashList(TEST_ITEM_INDEX));
        Assert.assertTrue(globalSQAPage.IsItemPresentInDefaultList(TEST_ITEM_INDEX_2));

        globalSQAPage.SwitchToDefaultContent();
    }
}
