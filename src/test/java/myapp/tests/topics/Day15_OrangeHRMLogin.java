package myapp.tests.topics;

import myapp.pages.OrangeHRM_DashboardPage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_OrangeHRMLogin {

    //Automate login functionality the https://opensource-demo.orangehrmlive.com/web/index.php/auth/login  using page object model
    // Given user is the application login page
    // Then enter the credentials
    // Then verify the login in successful
    // And logout the application
    // Then verify the logout is successful

    /*
    TRADITIONAL WAY
    @Test
    public void loginTest(){
        // Given user is the application login page
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Then enter the credentials
        Driver.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        Driver.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        // Then verify the login in successful
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
        // And logout the application
        Driver.getDriver().findElement(By.xpath("//p[text()='Admin12 Yazıcı']")).click();
        Driver.getDriver().findElement(By.xpath("//a[text()='Logout']")).click();
        // Then verify the logout is successful
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }
     */

    @Test
    public void loginTest(){

        // Given user is the application login page
        //Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //WaitUtils.waitFor(2);
        //ALTERNATIVELY
        Driver.getDriver().get(ConfigReader.getProperty("hrm_page"));

        // Then enter the credentials
        /*
           NOTE: I need to access the page objects
           To do this, create a page object
         */
        OrangeHRM_LoginPage orangeHRMLoginPage = new OrangeHRM_LoginPage();
        orangeHRMLoginPage.username.sendKeys("Admin");
        WaitUtils.waitFor(2);
        orangeHRMLoginPage.password.sendKeys("admin123");
        WaitUtils.waitFor(2);
        orangeHRMLoginPage.loginButton.click();
        WaitUtils.waitFor(2);
        //BrowserUtils.clickWithTimeOut(orangeHRMLoginPage.loginButton, 5);
        //ALTERNATIVELY WE CAN USE THE REUSABLE login METHOD-RECOMMENDED
        //orangeHRMLoginPage.login("Admin", "admin123");

        // Then verify the login in successful
        /*
           We can use the profile to do assertion
         */
        OrangeHRM_DashboardPage orangeHRMDashboardPage = new OrangeHRM_DashboardPage();
        //Assert.assertTrue(orangeHRMDashboardPage.profile.isDisplayed());
        //ALTERNATIVELY-RECOMMENDED-USE REUSABLE METHOD
        BrowserUtils.verifyElementDisplayed(orangeHRMDashboardPage.profile);
        WaitUtils.waitFor(2);

        // And logout the application
        //orangeHRMDashboardPage.profile.click();
        //WaitUtils.waitFor(2);
        //orangeHRMDashboardPage.logout.click();
        // ALTERNATIVELY use the proper reusable method
        BrowserUtils.clickWithTimeOut(orangeHRMDashboardPage.profile, 5); //dynamic custom method
        BrowserUtils.clickWithTimeOut(orangeHRMDashboardPage.logout, 5);

        // Then verify the logout is successful
        /*
           if username,password,login are displayed then logout is successful
         */
        BrowserUtils.verifyElementDisplayed(orangeHRMLoginPage.username);

        Driver.closeDriver();

    }






}

