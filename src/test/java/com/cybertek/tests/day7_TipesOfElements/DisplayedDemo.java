package com.cybertek.tests.day7_TipesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //verify username inputbox is not displayed in the screen
        //click start button
        //verufy username displayed on the screen

        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        Thread.sleep(6000);

        Assert.assertTrue(usernameInput.isDisplayed(), "veryfy username input box is displayed");

        //System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());



    }
}
