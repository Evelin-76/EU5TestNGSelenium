package com.cybertek.tests.day_7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {

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
        System.out.println("Closw browser");
    }

}
