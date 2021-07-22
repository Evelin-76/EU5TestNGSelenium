package com.cybertek.tests.day_12_properties_driver_test;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    WebDriver driver = Driver.get();

    @Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 " + s1);
        System.out.println("s2 " + s2);
    }
    @Test
    public void test2(){//This is the common way to open browser applying singleton concept
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.es/");

        //now to close browser we have to call the method closeDriver() from the constructor
        //this method is created explicitly in Driver class with get() method as well
//        Driver.closeDriver();->we close later since we are going to add now Tcs that
        //will use our same Driver object so we need to keep it open.If we close it a new null
        //chrome drive will be open
    }
    @Test
    public void test3(){
        Driver.get().get("https://google.com");//open browser directly
    }
    @Test
    public void test4(){//here we got browser because we create driver object at the top
        driver.get("https://www.amazon.es/");
        driver.navigate().back();
        Driver.closeDriver();
    }
}
