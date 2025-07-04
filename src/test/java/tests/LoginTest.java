package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

import java.io.IOException;

public class LoginTest extends BaseTest {


    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {

        String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][2];

        for (int i = 1; i < rowCount; i++) {

            data[i - 1][0] = ExcelUtils.getCellData(i, 0);    // Username
            data[i - 1][1] = ExcelUtils.getCellData(i, 1);    // Password
        }
        ExcelUtils.closeExcel();
        return data;
    }


    @Test(dataProvider = "LoginData")
    public void testValidLogin(String username, String password) {

        Log.info("Starting login test...");
        test = ExtentReportManager.createTest("Login Test" + username);
        LoginPage loginpage = new LoginPage(driver);

        test.info("Navigated to Login Page");
        //Log.info("Adding credentials");
        //loginpage.enterUsername("standard_user");
        loginpage.enterUsername(username);
        //loginpage.enterPassword("secret_sauce");
        loginpage.enterPassword(password);
        loginpage.clickLogin();
        test.info("Entered credentials and clicked Login");

        //System.out.println("------------> TITLE OF THE PAGE IS----------> " +driver.getTitle());
        //Log.info("Verifying page Title");
        test.info("Verifying Page Title");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

        Log.info("Login test completed");
        test.pass("Login Successfully");

    }
}
/*
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
*/
