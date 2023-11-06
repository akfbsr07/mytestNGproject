package myapp.tests.topics;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_ConfigReaderTest {

    @Test
    public void configReaderTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Driver.getDriver().navigate().refresh();
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(ConfigReader.getProperty("amazon_title")));
        Driver.closeDriver();
    }

}
