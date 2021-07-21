package com.cybertek.tests.day_12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    //now we can open all our url using same browser for every test since it is pointing
    //same object after private Driver constructor created in Driver class.
    //IT IS SINGLETON CONCEPT APPLIED
    WebDriver driver = Driver.get();

    @Test
    public void test1(){
       // Singleton singelton = new Singleton();-> we cannot create an object due constructor
                //  is private. We need to create an access to it through a method
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
    @Test
    public void test2(){
        //now we can access to url from method called by Driver directly and set it up in
        //configuration.properties file we created with all important data saved there
        WebDriver driver = Driver.get();

        driver.get("https://www.google.com");
    }
    @Test
    public void test3(){

        //calling methods directly by Class name since method is static. Driver has the
        //constructor parameterless created explicitly
        Driver.get().get("https://www.amazon.com");
    }
    @Test
    public void test4(){
       //we call now the method get() from Driver through the constructor at the top of the
       //class for make it useful in all test annotation, so next is get the url to navigate
        driver.get(ConfigurationReader.get("url"));//access to url set up in configuration.
                                                    //properties file created

    }
}
