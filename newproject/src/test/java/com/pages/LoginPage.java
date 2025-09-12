package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@FindBy(xpath = "//a[@id='loginlabel' and @class='lg_button']")
	WebElement loginclick;
	@FindBy(id = "user_login")
	WebElement uname;
	@FindBy(id = "user_pass")
	WebElement pass;
	@FindBy(id = "wp-submit")
	WebElement loginbutton;
	@FindBy(id = "gk-login-toggle")
	WebElement logoutclick;
	@FindBy(xpath = "//a[text()=\"Logout\"]")
	WebElement logoutbutton;

	public void loginportal(String usr, String pas) {
		loginclick.click();
		uname.sendKeys(usr);
		pass.sendKeys(pas);
		loginbutton.click();
	}

	

	public void logout() {

		logoutclick.click();
		logoutbutton.click();

	}

}
