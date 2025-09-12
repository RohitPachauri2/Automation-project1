package com.testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.pages.BaseTest;
import com.pages.LoginPage;
import com.pages.SearchPage;
import com.utility.ReadExcelFile;
@Test
public class SearchTestCase extends BaseTest{
String filename=System.getProperty("user.dir")+"\\TestData\\Book1.xlsx";
	public void searchtestcourse() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getcellvalue(filename, "LoginData", 0, 0);
		String password=ReadExcelFile.getcellvalue(filename, "LoginData", 0, 1);
		lp.loginportal(username, password);
		
		SearchPage sp=new SearchPage(driver);
		String coursename=ReadExcelFile.getcellvalue(filename, "searchdata", 0, 0);
		sp.searchcourse(coursename);
		
	}
}
