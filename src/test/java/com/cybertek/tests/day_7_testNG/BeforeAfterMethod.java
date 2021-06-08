package com.cybertek.tests.day_7_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @Test
    public void test1(){
        System.out.println("First Test Case");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("Second Test Case");
    }
    @Test
    public void test3(){
        System.out.println("Third Test Case");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("--WebDriver, Opening Browser--");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("--Closing Browser,Quit--");
    }
    @BeforeClass
    public void setUpClass() {
        System.out.println("**BEFORE CLASS**");
        System.out.println("Executed before class");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("**AFTER CLASS**");
        System.out.println("Executed after class");
    }


        }
