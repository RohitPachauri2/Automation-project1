package com.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.pages.BaseTest;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utility.ReadExcelFile;
@Test
public class DashboardTestCase extends BaseTest {
	String filename=System.getProperty("user.dir")+"\\TestData\\Book1.xlsx";
	
	public void clickdashboard() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		LoginPage lp=new LoginPage(driver);
		String user=ReadExcelFile.getcellvalue(filename, "LoginData", 0, 0);
		String pass=ReadExcelFile.getcellvalue(filename, "LoginData", 0, 1);
		lp.loginportal(user, pass);
		DashboardPage dp=new DashboardPage(driver);
		dp.dashboardclick();
		
	}
	}


