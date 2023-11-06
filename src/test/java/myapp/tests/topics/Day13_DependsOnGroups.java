package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day13_DependsOnGroups {

    @Test(groups = "smoke-test")
    public void homePageTest(){
        System.out.println("home page...");
    }

    @Test(groups = "smoke-test")
    public void searchTest(){
        System.out.println("search test...");
        Assert.assertTrue(false);

    }

    @Test(groups = "regression-test")
    public void checkOutTest(){
        System.out.println("checkout test...");
    }

    @Test(dependsOnGroups = "smoke-test") //logOut is dependent on smoke-test group. If all smoke-test groups pass then this executes, otherwise it will be skipped
    public void logOutTest(){
        System.out.println("logout test...");
    }






}
