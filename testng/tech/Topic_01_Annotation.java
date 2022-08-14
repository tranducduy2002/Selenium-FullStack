package tech;

import org.testng.annotations.*;

public class Topic_01_Annotation {
    @Test (groups = "user")
    public void Register() {
        System.out.println("Register function");
    }

    @Test (groups = "user")
    public void Login() {
        System.out.println("Login function");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");

    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Group");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("After Group");
    }

}