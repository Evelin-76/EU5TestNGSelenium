package com.cybertek.tests.day7_TipesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBth = driver.findElement(By.id("blue"));

        System.out.println("value attribute = "  + blueRadioBth.getAttribute("value"));

        //get the value of type attribute
        System.out.println(blueRadioBth.getAttribute("type"));
        //get the value of name attribute
        System.out.println(blueRadioBth.getAttribute("name"));
        //get the value of checked attribute
        //since checked att. does not keep any value, it will return true or false bases on the condition exist or not
        System.out.println(blueRadioBth.getAttribute("checked"));
        //trying to get an attribute that does not exist it returns null
        System.out.println(blueRadioBth.getAttribute("href"));

        //all elements to string belong to attribute
        System.out.println(blueRadioBth.getAttribute("outerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println("innerHTML = "  + button2.getAttribute("innerHTML"));


        driver.quit();

    }
}
