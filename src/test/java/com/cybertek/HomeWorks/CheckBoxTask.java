package com.cybertek.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class CheckBoxTask {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void Section1() {
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement SingleCheckbDemo = driver.findElement(By.xpath("//*[.=\"Success - Check box is checked\"]"));

        Assert.assertTrue(!SingleCheckbDemo.isDisplayed(),"Verify tex 'Success - Check box is checked' is not displayed");

        driver.findElement(By.id("isAgeSelected")).click();

        Assert.assertFalse(!SingleCheckbDemo.isDisplayed(),"Verify tex 'Success - Check box is checked' is not displayed");

    }


        @Test
    public void Section2(){
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        System.out.println(driver.findElement(By.xpath("//input[@value='Check All']")).getAttribute("value"));
        String actualValueText = driver.findElement(By.xpath("//input[@value='Check All']")).getAttribute("value");
        String expecedValueText = "Check All";
        Assert.assertEquals(actualValueText,expecedValueText, "Verify actual text is 'Check All'");

        driver.findElement(By.xpath("//input[@value='Check All']")).click();

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".cb1-element"));

        for (WebElement checkBox : checkBoxes) {
            if(checkBox.isSelected()){
                System.out.println("True");
            }else{
                System.out.println("False");
            }

        }
    }
}
