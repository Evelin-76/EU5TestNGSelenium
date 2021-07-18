package com.cybertek.HomeWorks.eu2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataProviderExample {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public  void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        wait=new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @DataProvider
    public Object[][] getData(){
        Object [][] status=new Object[4][2];
        status[0][0]="li>a[href*=\"status_codes/200\"]";
        status[0][1]="This page returned a 200 status code";
        status[1][0]="li>a[href*=\"status_codes/301\"]";
        status[1][1]="This page returned a 301 status code";
        status[2][0]="li>a[href*=\"status_codes/404\"]";
        status[2][1]="This page returned a 404 status code";

        status[3][0]="li>a[href*=\"status_codes/500\"]";
        status[3][1]="This page returned a 500 status code";

        return status;

    }
    @Test(dataProvider = "getData")
    public void test1(String  statusCode,String statusError) throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.xpath("//a[contains(text(),\"Status\")]")).click();
        driver.findElement(By.cssSelector(statusCode)).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//p")).getText();
      String  actualText=text.substring(0,text.indexOf("."));
        Assert.assertEquals(actualText,statusError,"verifying errors");


    }
}