package com.utility;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactor{

    public static WebDriver startApplication(WebDriver driver, String browser, String url) {
        // Determine which browser to use based on input
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();  // Automatically set up chromedriver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");  // Example: Maximizing window
            driver = new ChromeDriver(options);
        } 
        else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();  // Automatically set up geckodriver
            driver = new FirefoxDriver();
        } 
        else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();  // Automatically set up edgedriver
            driver = new EdgeDriver();
        } 
        else {
            System.out.println("Browser not supported!");
            return null;
        }
        if (driver == null) {
            System.out.println("Failed to initialize driver.");
            return null;
        }
        
        driver.get(url);
        driver.manage().window().maximize();// Open the URL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;    // Return the initialized driver
    }
    public static void quitapplication(WebDriver driver) {
    	driver.quit();
    }
}
