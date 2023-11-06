package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechproHomePage {

    public TechproHomePage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//h2[text()=' Secure Area']")
    public WebElement pageHeader;

    @FindBy(xpath = "//i[@class='fa fa-sign-out-alt']")
    public WebElement logoutButton;




}
