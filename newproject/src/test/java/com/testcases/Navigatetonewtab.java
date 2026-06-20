package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigatetonewtab {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Step 1: Open the first URL
        driver.get("https://www.youtube.com/");
        Thread.sleep(2000);

        // Step 2: Execute JavaScript to open a new blank tab
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.google.com', '_blank');");
        
        // Step 3: Wait for a bit to ensure the tab opens
        Thread.sleep(2000);

        // Step 4: Switch to the new tab
        // Get window handles and switch to the new tab
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;  // Break once the new tab is found
            }
        }

        // Step 5: Confirm you are on the new tab (Google in this case)
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Step 6: Close the browser
        Thread.sleep(2000);
        driver.switchTo().window(currentWindowHandle);
        Thread.sleep(2000);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        driver.quit();
    }
}
