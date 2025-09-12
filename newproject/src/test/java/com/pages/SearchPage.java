package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	private WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id=\"search_course\"][class=\"search_course_mobile_hidden border-radius-sm\"]")
	WebElement searchbox;

	public void searchcourse(String courseName) {
		searchbox.sendKeys(courseName);
		searchbox.sendKeys(Keys.ENTER);
	}
}
