package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;


    //Locators
    private By usernameTextBox = By.id("user-name");
    private By passwordTextBox = By.id("password");
    private By loginButton = By.id("login-button");

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void enterUsername(String username){
        driver.findElement(usernameTextBox).clear();
        driver.findElement(usernameTextBox).sendKeys(username);

    }

    public void enterPassword(String password){
        driver.findElement(passwordTextBox).clear();
        driver.findElement(passwordTextBox).sendKeys(password);

    }

    public void clickLogin(){
        driver.findElement(loginButton).click();

    }

}
