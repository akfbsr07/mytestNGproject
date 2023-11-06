package myapp.tests.listeners;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/*
   We can link test method to Listeners with 2 different ways:
   -1. We can use @Listeners annotation to implement Listeners
   -2. <listeners> to in xml file- recommended way
 */



//@Listeners(myapp.utilities.ListenerUtils.class)
//instead of annotation above, use <listeners> in xml file
public class Day18_ListenersTest {

    @Test
    public void test1(){
        System.out.println("PASS");
        Assert.assertTrue(true);
    }

    @Test
    public void test2(){ // blank screenshot because no UI
        System.out.println("FAILS");
        Assert.assertTrue(false);
    }

    @Test
    public void test3(){
        System.out.println("SKIPPED");
        throw  new SkipException("Skipping test case on purpose");
    }

    @Test
    public void test4(){ //takes screenshot of Amazon page
        System.out.println("THROW EXCEPTION");
        //throw new NoSuchElementException("Throw NoSuchElementException on purpose");
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().findElement(By.id("wrong-id")); // Throws NoSuchElementException
    }

}
