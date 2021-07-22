package com.cybertek.tests.day_12_properties_driver_test;

import com.cybertek.tests.TestBase;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    //All TCs running in same browser pointed by same object
    @Test
    public void test1(){
        driver.get("http://www.google.com");
    }
//THESE ARE WORKING IF I APPLY @AFTERCLASS ANNOT. IN TestBase instead of @AfterMethod
//    @Test
//    public void test2(){
//        driver.navigate().back();
//    }
//    @Test
 //   public void test3(){
 //       driver.get("https://amazon.com");
//  }


}
