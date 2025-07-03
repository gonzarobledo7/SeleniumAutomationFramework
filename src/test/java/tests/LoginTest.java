package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BasePage {

    @Test
    public void testValidLogin(){

        Log.info("Starting login test...");
        test = ExtentReportManager.createTest("Login Test");
        LoginPage loginpage = new LoginPage(driver);

        test.info("Navigated to Login Page");
        //Log.info("Adding credentials");
        loginpage.enterUsername("standard_user");
        loginpage.enterPassword("secret_sauce");
        loginpage.clickLogin();
        test.info("Entered credentials and clicked Login");

        //System.out.println("------------> TITLE OF THE PAGE IS----------> " +driver.getTitle());
        //Log.info("Verifying page Title");
        test.info("Verifying Page Title");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

        Log.info("Login test completed");
        test.pass("Login Successfully");

    }

    @Test
    public void testLoginWithInvalidCredentials(){

        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";

        Log.info("Starting Invalid login test...");
        test = ExtentReportManager.createTest("Login Test with invalid credentials");
        LoginPage loginpage = new LoginPage(driver);

        test.info("Navigated to Login Page");
        //Log.info("Adding credentials");
        loginpage.enterUsername("standard_user");
        loginpage.enterPassword("secret_sauce123");
        loginpage.clickLogin();
        test.info("Entered Invalid credentials and clicked Login");

        test.info("Verifying Error Message displayed");
        String actualError = loginpage.getErrorText();
        Assert.assertEquals(actualError, expectedMessage);

        Log.info("Login test completed");
        test.pass("Login Successfully");

    }


}
