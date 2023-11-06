package myapp.pages;

import myapp.utilities.BrowserUtils;
import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechproLoginPage {

    public TechproLoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    public void login(String userID, String userPass){

        BrowserUtils.sendKeysWithTimeout(username, userID, 10);
        BrowserUtils.sendKeysWithTimeout(password, userPass, 10);
        BrowserUtils.clickWithTimeOut(loginButton, 10);

    }




}
