package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_DashboardPage {
    // 1. Create constructor
    // 2. Locate elements using @FindBy
    public OrangeHRM_DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "oxd-userdropdown-name")
    public WebElement profile;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logout;






}
