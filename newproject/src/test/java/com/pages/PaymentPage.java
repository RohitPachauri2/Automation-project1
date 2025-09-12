package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriver and PageFactory
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // wait timeout for elements
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li[class='f_p col-md-6 col-xs-6']>label") WebElement checkbox;
    @FindBy(css = "input[id='learn-press-checkout-place-order']") WebElement place_order;
    @FindBy(css = ".__PrivateStripeElement > iframe:nth-child(1)") WebElement frame1;
    @FindBy(css = "span[class='CardField-restWrapper']") WebElement cardnum;
    @FindBy(css = "span[class='InputContainer']>input[autocomplete='cc-number']") WebElement date1;
    @FindBy(css = "span[class='InputContainer']>input[autocomplete='cc-csc']") WebElement cvv1;
    @FindBy(css = "#payment-button") WebElement paynow;

    public void payment(String num, String date, String cvv) {
        // Wait for checkbox to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
        
        // Wait for 'Place Order' button to be clickable and click it using JavaScript
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(place_order));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderButton);

        // Switch to iframe and wait for card number field to be visible
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".__PrivateStripeElement > iframe:nth-child(1)")));

        WebElement cardNumberField = wait.until(ExpectedConditions.elementToBeClickable(cardnum));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", cardNumberField, num);
        System.out.println("Card number entered via JavaScript");

        // Use JavaScript to send keys to the expiration date field directly
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(date1));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", dateField, date);
        System.out.println("Date entered via JavaScript");

        // Use JavaScript to send keys to the CVV field directly
        WebElement cvvField = wait.until(ExpectedConditions.elementToBeClickable(cvv1));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", cvvField, cvv);
        System.out.println("CVV entered via JavaScript");

        // Switch back to the main content
        driver.switchTo().defaultContent();

        // Wait for 'Pay Now' button and click it
        WebElement payNowButton = wait.until(ExpectedConditions.elementToBeClickable(paynow));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", payNowButton);
        System.out.println("Pay now clicked via JavaScript");
    }


}
