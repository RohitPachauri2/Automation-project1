package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	private WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[class='lg_button']") WebElement dashboard;
	@FindBy(css=".academies_tab") WebElement offered_academics;
	@FindBy(css="li.course:nth-child(2) > form:nth-child(5) > div:nth-child(1) > button:nth-child(1)") WebElement subscribe;
	public void dashboardclick() {
		dashboard.click();
		offered_academics.click();
		subscribe.click();
		
	}

}
