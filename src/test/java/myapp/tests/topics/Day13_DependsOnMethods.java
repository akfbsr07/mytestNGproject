package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day13_DependsOnMethods {

    @Test
    public void homePageTest(){
        System.out.println("home page...");
    }

    @Test
    public void searchTest(){
        System.out.println("search test...");
        Assert.assertTrue(true);
        //Assert.assertTrue(false); //if searchTest failed, checkOutTest will not run
    }

    @Test(dependsOnMethods = "searchTest") //checkOut is dependent on search, if search fails checkout will not run
    public void checkOutTest(){
        System.out.println("checkout test...");
    }








}
