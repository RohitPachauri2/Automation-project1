package com.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newseleniumgrid {
	@Test
    public void test1() throws MalformedURLException, InterruptedException {
        // Use FirefoxOptions instead of DesiredCapabilities
		System.out.println("Test 1 Started-----------");
		System.setProperty("webdriver.gecko.driver", "D://rohit//geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setPlatformName(Platform.WINDOWS.toString());
        

        // Now you are creating a RemoteWebDriver to communicate with the Grid Hub
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.25:4444/wd/hub"), options);
        
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        
        System.out.println("Title of the Page is: " + driver.getTitle());
        Thread.sleep(10);
        
        // Clean up after the test
        driver.quit();
        System.out.println("Test 1 Ended-----------");
    }
	
	@Test
    public void test2() throws MalformedURLException, InterruptedException {
        // Use FirefoxOptions instead of DesiredCapabilities
		System.out.println("Test 2 Started-----------");
		System.setProperty("webdriver.gecko.driver", "D://rohit//geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setPlatformName(Platform.WINDOWS.toString());
        

        // Now you are creating a RemoteWebDriver to communicate with the Grid Hub
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.25:4444/wd/hub"), options);
        
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        
        System.out.println("Title of the Page is: " + driver.getTitle());
        Thread.sleep(10);
        
        // Clean up after the test
        driver.quit();
        System.out.println("Test 2 Ended-----------");
    }
	
	@Test
    public void test3() throws MalformedURLException, InterruptedException {
        // Use FirefoxOptions instead of DesiredCapabilities
		System.out.println("Test 3 Started-----------");
		System.setProperty("webdriver.gecko.driver", "D://rohit//geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setPlatformName(Platform.WINDOWS.toString());
        

        // Now you are creating a RemoteWebDriver to communicate with the Grid Hub
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.25:4444/wd/hub"), options);
        
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        
        System.out.println("Title of the Page is: " + driver.getTitle());
        Thread.sleep(10);
        
        // Clean up after the test
        driver.quit();
        System.out.println("Test 3 Ended-----------");
    }
	
}
