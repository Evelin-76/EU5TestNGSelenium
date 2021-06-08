package com.cybertek.tests.day_4_basic_locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();//maximazing window browser
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement furllNameInput = driver.findElement(By.tagName("input"));
        furllNameInput.sendKeys("Mike with TagName");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("mike@smith.com");
        Thread.sleep(3000);
        //shortcut to click button
        driver.findElement(By.tagName("button")).click();

        driver.quit();
    }
}
