package com.selenium.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseClass {

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static String webBrowserName = "Chrome";

	// Web driver setup
	public static WebDriver GetDriver() {
		if (driver.get() == null) {
		      WebDriverManager.chromedriver().setup();
		      driver.set(new ChromeDriver());
		    }		    
		    return driver.get();
	}
	
	public void SetUpApplication() {
		// SetUp some driver settings
        GetDriver().manage().deleteAllCookies();
		GetDriver().manage().window().maximize();
		GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void QuitApplication() {
		GetDriver().quit();
		driver.set(null);
	}
	
	public void CloseApplication() {
		GetDriver().close();
		driver = null;
	}

	// Screenshot setup
	public void CaptureScreenshot(String testMethodName){
		// Calculate path for future screenshot
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
		String timeStamp = dateFormat.format(currentDate);
		String workingDirectory = System.getProperty("user.dir");

		String directoryPath =
				String.format("%s/test-output/FailedTestScreenshots/%s", workingDirectory, testMethodName);
		String filePath =
				String.format("%s/%s_%s.jpg", directoryPath, testMethodName, timeStamp);

		try {
			// Create new folder if it not exists
			File screenshotDirectory = new File(directoryPath);
			if (!screenshotDirectory.exists()){
				screenshotDirectory.mkdirs();
			}
			// Create screenshot
			File screenshotFile = ((TakesScreenshot) GetDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(filePath));
		}
		catch(Exception e){
			e.getMessage();
		}
	}
}
