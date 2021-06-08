package com.cybertek.tests.day_7_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","ur_l");

    }

}
