package myapp.homeworks;

import myapp.pages.TechproHomePage;
import myapp.pages.TechproLoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class HW1_TechproLoginTest {

    /*
    https://testcenter.techproeducation.com/index.php?page=form-authentication
    Test the Login and logout functionality of the application using page object model
    PAGES:
    TechproLoginPage
            userName
            password
            submitButton
    TechproHomePage
            homeHeader
            homeLogoutButton
    TEST:
    Class: TechproLoginTest
    Methot : loginTest()
    CONFIG READER:
            techpro_test_url = https://testcenter.techproeducation.com/index.php?page=form-authentication
            techpro_test_username = techproed
            techpro_test_password=SuperSecretPassword
    */

    @Test
    public void loginTest(){
        // Go to page
        Driver.getDriver().get(ConfigReader.getProperty("techpro_test_url"));

        //Login
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        techproLoginPage.login(ConfigReader.getProperty("techpro_test_username"), ConfigReader.getProperty("techpro_test_password"));

        //Verify Login
        TechproHomePage techproHomePage = new TechproHomePage();
        BrowserUtils.verifyElementDisplayed(techproHomePage.pageHeader);

        //Logout
        BrowserUtils.clickWithTimeOut(techproHomePage.logoutButton, 10);

        //Verify Logout
        BrowserUtils.verifyElementDisplayed(techproLoginPage.username);

        Driver.closeDriver();

    }






}
