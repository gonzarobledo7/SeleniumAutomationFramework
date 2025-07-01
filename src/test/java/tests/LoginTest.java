package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BasePage {

    @Test
    public void testValidLogin(){
        LoginPage loginpage = new LoginPage(driver);

        loginpage.enterUsername("admin@yourstore.com");
        loginpage.enterPassword("admin");
        loginpage.clickLogin();

        System.out.println("------------> TITLE OF THE PAGE IS----------> " +driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");

    }
}
