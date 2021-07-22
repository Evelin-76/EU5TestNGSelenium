package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
//Task: open a WebDriver Chrome or FireFox with our custom method created
    public static WebDriver getDriver (String browserType){

        WebDriver driver = null;

         switch (browserType.toLowerCase()){
             case "chrome":
                 WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
                 break;
             case "firefox":
                 WebDriverManager.firefoxdriver().setup();
                 driver = new FirefoxDriver();
                 break;
             }
         return driver;
    }
}
//import io.github.bonigarcia.wdm.WebDriverManager;
 //       import org.openqa.selenium.WebDriver;
 //       import org.openqa.selenium.chrome.ChromeDriver;
 //       import org.openqa.selenium.firefox.FirefoxDriver;


//public class WebDriverFactory {
    //Task: open a WebDriver Chrome or FireFox with our custom method created
//    private static WebDriver driver;

//    public static WebDriver getDriver(String browserType) {


//        if (driver == null) {
//            switch (browserType.toLowerCase()) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//            }

//        }return driver;
//    }
//}
