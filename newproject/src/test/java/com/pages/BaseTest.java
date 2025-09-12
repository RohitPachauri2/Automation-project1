package com.pages;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.utility.BrowserFactor;
import com.utility.ConfigDataProvider;

public class BaseTest {
	public WebDriver driver;
	public ConfigDataProvider cdp=new ConfigDataProvider();
	@BeforeClass
	public void setup() {
		driver=BrowserFactor.startApplication(driver,cdp.getbrowser(), cdp.geturl());
	}
	@AfterClass
	public void shutdown() {
	    if (driver != null) {
	        BrowserFactor.quitapplication(driver);
	    } else {
	        System.out.println("Driver is null, skipping quit.");
	    }
	}

}
