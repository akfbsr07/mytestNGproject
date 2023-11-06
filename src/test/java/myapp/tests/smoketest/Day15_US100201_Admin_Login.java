package myapp.tests.smoketest;

import myapp.pages.BlueRentalDefaultPage;
import myapp.pages.BlueRentalHomePage;
import myapp.pages.BlueRentalLoginPage;
import myapp.utilities.*;
import org.testng.annotations.Test;

public class Day15_US100201_Admin_Login {

    /*
      ADD EXTENT REPORTS CAPABILITY
      1. Use createTestReport(String name, String description) first for creating extent report capability
      2. Then use any method to mark as pass, info, fail
      3. Add flush() to create report
     */

    /*
       ADD LOGGER REPORT CAPABILITY
       1. use any method from LoggerUtils directly
     */
    @Test
    public void US100201_Admin_Login(){

        //Using LoggerUtils
        LoggerUtils.info("Test case begins...");

        ExtentReportUtils.createTestReport("Smoke Test Report", "Admin Login Test");
        ExtentReportUtils.pass("Starting the admin login test...");

      //Acceptance Criteria:
        //As admin, I should be able to log in the application
        //Go to https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("bluerental_defaultpage"));

        ExtentReportUtils.pass("User in on the default page...");

        BlueRentalDefaultPage blueRentalDefaultPage = new BlueRentalDefaultPage();
        BrowserUtils.clickWithTimeOut(blueRentalDefaultPage.loginButton, 10);

        ExtentReportUtils.pass("Navigated to the login page...");

        //Then Login
        //Admin email: jack1@gmail.com
        //Admin password: 12345

        ExtentReportUtils.info("Entering Admin credentials...");

        BlueRentalLoginPage blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalLoginPage.login(ConfigReader.getProperty("bluerental_email"), ConfigReader.getProperty("bluerental_password"));

        ExtentReportUtils.passAndCaptureScreenshot("Entered Admin credentials, and clicked on login button successfully...");

        //Verify login successfull
        BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();
        BrowserUtils.verifyElementDisplayed(blueRentalHomePage.profile);

        ExtentReportUtils.passAndCaptureScreenshot("Login is verified...");

        Driver.closeDriver();

        ExtentReportUtils.pass("Driver is closed...Test case passed successfully...");

        ExtentReportUtils.flush();

        //Logger Utils
        LoggerUtils.info("Test completed...");

    }








}
