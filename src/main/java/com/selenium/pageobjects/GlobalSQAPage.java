package com.selenium.pageobjects;

import com.selenium.actiondriver.Action;

public class GlobalSQAPage {
    Action action = new Action();

    public void WaitForPageToLoad(){
        action.WaitForElementToBeVisible(GlobalSQAPageLocators.MainHeader, 20);
    }

    public void SwitchToIframe(){
        action.SwitchToIFrame(GlobalSQAPageLocators.Iframe);
    }

    public void SwitchToDefaultContent(){
        action.LeaveIFrame();
    }

    public void MoveItemToTrashBin(int galleryItemIndex){
        action.DragAndDropItem(GlobalSQAPageLocators.GalleryItem(galleryItemIndex), GlobalSQAPageLocators.TrashBin);
    }

    public boolean IsItemPresentInDefaultList(int galleryItemIndex){
        return action.IsElementPresentAfterWait(GlobalSQAPageLocators.GalleryItem(galleryItemIndex), 5);
    }

    public boolean IsItemPresentInTrashList(int galleryItemIndex){
        return action.IsElementPresentAfterWait(GlobalSQAPageLocators.GalleryItemInTrash(galleryItemIndex), 5);
    }
}
