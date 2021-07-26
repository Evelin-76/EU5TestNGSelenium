package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver =  Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));
    }

    //IT IS CLOSING BROWSER AFTER FIRST TC
    // IT IS USEFUL BECAUSE WE WANT OUR TCs INDEPENDENT FORM EACH OTHER
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
        //driver.quit();
    }
//IT is running all of our TCs pointed by same object applying singleton design
//    @AfterClass // @AfterMethod
//    public void tearDownTest(){
//        Driver.closeDriver();
//    }
}
