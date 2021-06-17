package com.cybertek.tests.day_9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopusAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click Click for JS Alert Button
        driver.findElement(By.xpath("//*[@onclick= 'jsAlert()']")).click();

        //switch to JS alert por up
        Alert alert = driver.switchTo().alert();
        //accept
        alert.accept();

        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        alert.accept();

        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        //sendkeys to the input box
        alert.sendKeys("YOYO");
        //accept
        alert.accept();



    }

}
