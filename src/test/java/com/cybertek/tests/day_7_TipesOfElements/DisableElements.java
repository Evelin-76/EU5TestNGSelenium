package com.cybertek.tests.day_7_TipesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElements {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenButtonDisable = driver.findElement(By.id("green"));

        //how to check if any web element is enable or not
        //System.out.println(greenButtonDisable.isEnabled());//will get false, it is not enable

        Assert.assertFalse(greenButtonDisable.isEnabled(), "verify green button is NOT enable");

        greenButtonDisable.click();
    }

        @Test
        public void test2(){

            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();

            driver.get("http://practice.cybertekschool.com/dynamic_controls");

            WebElement enableDisableBox = driver.findElement(By.cssSelector("#input-example>input"));

            System.out.println(enableDisableBox.isEnabled());

            enableDisableBox.sendKeys("hola");//fail because it is disable

        }




}
