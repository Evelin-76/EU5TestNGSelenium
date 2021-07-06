package com.cybertek.tests.day_9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreatSleepExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        //it is the static way to stop execution for minutes we select when we need to do it if
        //it is necessary when we want to run our codes and it requires time to be loaded
        Thread.sleep(6000);
        driver.findElement(By.id("username")).sendKeys("Lucas");
    }
}
