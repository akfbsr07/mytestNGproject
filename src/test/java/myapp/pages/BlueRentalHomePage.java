package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRentalHomePage {

    public BlueRentalHomePage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//button[text()='Jack Nickolson']")
    public WebElement profile;



}
