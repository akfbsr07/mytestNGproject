package myapp.tests.topics;

import org.testng.annotations.*;

public class Day13_Annotations {

    /*
       @Test: Is used to create test cases - same as junit
       @Before and @After annotations: There are 5 before and after annotations in testNG
       Hierarchy: suite > test > group > class > method
       @Ignore: This is used to ignore/skip test cases
       @Test(enabled = false): This is used to disable the test cases
       @Test(priority = 1): Orders/Prioritize test cases, bey default testNG runs in alphabetical order(NOT FROM TOP TO BOTTOM), ascending order, default priority=0
     */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite...");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test...");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("before groups...");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class...");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method...");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite...");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test...");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.println("after groups...");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("after class...");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method...");
    }
    @Test(priority = 3, groups = "minor_regression_group")
    public void test1(){
        System.out.println("test case 1...");
    }
    @Test @Ignore
    public void test2(){
        System.out.println("test case 2...");
    }
    @Test(enabled = false)
    public void test3(){
        System.out.println("test case 3...");
    }
    @Test(priority = 2, groups = "minor_regression_group")
    public void test4(){
        System.out.println("test case 4...");
    }
    @Test(priority = 1)
    public void test5(){
        System.out.println("test case 5...");
    }






}
