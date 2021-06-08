package com.cybertek.tests.day_4_basic_locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextandPartialLinkText {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        //using full text of the element to find it and click on it
        WebElement linkExample1 = driver.findElement(By.linkText("Example 1: " +
                "Element on page that is hidden and become visible after trigger"));
        linkExample1.click();

        driver.navigate().back();

        //using partial text of the element to find it and click on it
        WebElement linkExample4 = driver.findElement(By.partialLinkText("Example 4"));
        linkExample4.click();

        driver.quit();
    }
}
