package com.cybertek.tests.day_7_testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {

    @Test
    public void test1(){
        System.out.println("WebDriver, Opening Browser");
        System.out.println("First Test Case");
        System.out.println("Closing Browser,Quit");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("WebDriver, Opening Browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Closing Browser,Quit");
    }


        }
