package com.selenium.pageobjects;

import org.openqa.selenium.By;

interface GlobalSQAPageLocators {

    By MainHeader = By.xpath("//h1[text()='Drag And Drop']");
    By Iframe = By.xpath("//div[@rel-title='Photo Manager']/p/iframe");
    By TrashBin = By.id("trash");

    static By GalleryItem(int index) {
        String galleryItemLocator =
                String.format("//*[@id='gallery']/li[%d]", index);
        return By.xpath(galleryItemLocator);
    }

    static By GalleryItemInTrash(int index) {
        String galleryItemLocator =
                String.format("//*[@id='trash']//li[%d]", index);
        return By.xpath(galleryItemLocator);
    }
}
