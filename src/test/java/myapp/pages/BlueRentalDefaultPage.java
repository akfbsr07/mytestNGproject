package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRentalDefaultPage {

    public BlueRentalDefaultPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginButton;



}
