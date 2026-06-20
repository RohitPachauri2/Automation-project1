package com.testcases;

import java.time.Duration;
import org.testng.annotations.Test;
import com.pages.BaseTest;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.PaymentPage;
import com.utility.ReadExcelFile;


public class PaymentTestCase extends BaseTest {
    String filename = System.getProperty("user.dir") + "\\TestData\\Book1.xlsx";
    @Test 
    public void nowpaying() {
        try {
            System.out.println("Starting PaymentTestCase");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Debugging statement to check if login is working
            System.out.println("Logging in with user credentials");

            LoginPage lp = new LoginPage(driver);
            String user = ReadExcelFile.getcellvalue(filename, "LoginData", 0, 0);
            String pass = ReadExcelFile.getcellvalue(filename, "LoginData", 0, 1);
            lp.loginportal(user, pass);

            // Check if login was successful
            System.out.println("Login successful");

            // Continue with the rest of the test
            DashboardPage dp = new DashboardPage(driver);
            dp.dashboardclick();
            System.out.println("Dashboard clicked");
            Thread.sleep(2);
            PaymentPage pp = new PaymentPage(driver);
            String cardnum = String.valueOf(ReadExcelFile.getcellvalue(filename, "LoginData", 0, 2));
            String date1 = String.valueOf(ReadExcelFile.getcellvalue(filename, "LoginData", 0, 3));
            String cvv1 = String.valueOf(ReadExcelFile.getcellvalue(filename, "LoginData", 0, 4));
            

            // Debugging the values fetched from Excel
            System.out.println("Card number: " + cardnum);
            System.out.println("Card expiration date: " + date1);
            System.out.println("Card CVV: " + cvv1);
            Thread.sleep(2);

            pp.payment(cardnum, date1, cvv1);
            Thread.sleep(2);
            System.out.println("Payment completed");
        } catch (Exception e) {
            System.out.println("Error occurred in PaymentTestCase: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
