package myapp.tests.topics;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_DriverTest {

    @Test
    public void driverTest(){
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().navigate().refresh();
        //get the page title
        String amazonTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        //closing driver
        Driver.closeDriver();
    }

    @Test
    public void driverTest2(){
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("Porcelain Tea Pot" + Keys.ENTER);
    }






}
