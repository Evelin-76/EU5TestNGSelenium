package com.cybertek.tests.day_7_TipesOfElements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radio button "blue" and "red"
        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        //check this condition printing it.
      //  System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
      //  System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        //how to click radio buttons:
        redRadioButton.click();

        //verify blue is selected and red is not selected
        Assert.assertTrue(blueRadioButton.isSelected(), "verify that blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(), "verify that red is NOT selected");

        //verify red is selected and red is not selected
        Assert.assertTrue(redRadioButton.isSelected(), "verify that blue is selected");
        Assert.assertFalse(blueRadioButton.isSelected(), "verify that red is NOT selected");

        driver.quit();

    }
}
