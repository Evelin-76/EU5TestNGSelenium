package com.cybertek.tests.day_12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){

    String browserType = ConfigurationReader.get("browser");

        System.out.println(browserType);

        String url = ConfigurationReader.get("url");


    }
}
