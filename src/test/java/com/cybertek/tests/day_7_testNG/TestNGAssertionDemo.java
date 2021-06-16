package com.cybertek.tests.day_7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {

    @Test
    public void test3(){
        String expectedTitle = "Cyt";
        String actualTitle = " Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title starts with Cyb");
    }
    @Test
    public void test4(){
        //verify email contains @ sign
        String email = "mike@smith.com";

        Assert.assertTrue(email.contains("@"), "Verify email contains @");
    }
    @Test
    public void test5(){
        Assert.assertFalse(0 < 1, "Verify that 0 is not greater than 1");
    }
    @Test
    public void test6() {
        System.out.println("Assert.assertNotEquals(\"one\",\"once\")");
        Assert.assertNotEquals("one","once");
    }

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","ur_l");

        System.out.println("Third Assertion");
        Assert.assertEquals("but","but");

    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Open browser");
    }
    @AfterMethod
    public void tearD(){
        System.out.println("Close browser");
    }

}
