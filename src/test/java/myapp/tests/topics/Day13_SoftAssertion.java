package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day13_SoftAssertion {

    @Test
    public void hardAssert(){
        /*
        TestNG
        Hard Assertion: If an assertion fails, then test case STOPS execution
        Assert class is used for hard assertion in TestNG
        Hard assertion is more common than Soft assert
         */
        System.out.println("line 14..."); //prints
        Assert.assertTrue(true); //PASS so continue
        System.out.println("line 17..."); //prints
        Assert.assertTrue(false); //FAILS so do not run rest of the test case
        System.out.println("line 19..."); //does not print
    }

    @Test
    public void javaAssert(){
        /*
        Java
        This is also hard assertion, but it comes from Java
        if this assertion fails, then test case STOPS execution
        We prefer TestNG assertion instead of java assertion
        if assert fails, then throw java.lang.AssertionError
         */
        System.out.println("line 31..."); //prints
        assert 3<5; //PASS
        System.out.println("line 33..."); //prints
        assert "apple"=="apple";
        System.out.println("line 35..."); //prints
        assert "Apple".toLowerCase().contains("a");
        System.out.println("line 37...");
        assert "java".equals("selenium"); //FAILS so do not run rest of the test case
        //if("java".equals("selenium")){PASS}else{throw java.lang.AssertionError}
        System.out.println("line 39..."); //does not print
    }

    @Test
    public void softAssertion(){
        /*
        Soft Assertion: If a soft assertion fails, test case will continue to execute
        STEPS:
        1. create soft assert object
        2. use the soft assert for assertions
        3. use assertAll() to get the result
         */
        System.out.println("line 53..."); //prints
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(5, 5);//PASS continue
        System.out.println("line 57..."); //prints
        softAssert.assertTrue(false);//FAILS but still continue
        System.out.println("line 59..."); //prints
        softAssert.assertEquals("apple", "orange");//FAILS but still continue
        System.out.println("line 61..."); //prints
        softAssert.assertAll("Test Case Completed..."); //if we do not use assertAll at the end, test case will be checked as pass even if it fails
    }






}
