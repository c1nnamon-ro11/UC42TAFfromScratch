package com.selenium.base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestListenerClass extends BaseClass implements ITestListener{
    @Test
    public void onTestFailure(ITestResult result) {
        try{
            CaptureScreenshot(result.getName());
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
