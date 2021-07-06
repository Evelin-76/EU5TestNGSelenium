package com.cybertek.tests.day_9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

        //metthod for wait the necessary time one page will need to load for get the result we want
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        driver.findElement(By.id("username")).sendKeys("Lucas");
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        //implicity method that provide results after the time page needs to load implicitly
        //we apply to before method so it will run for all test@ annotations
       //--> driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.id("finish"));

        System.out.println(element.getText());
    }
}
