package com.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BaseClass {

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static String webBrowserName = "Chrome";
	
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
}
