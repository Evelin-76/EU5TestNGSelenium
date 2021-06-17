package com.cybertek.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumEasy {

    WebDriver driver;

    @Test
    public void tc2(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.get(" http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

       WebElement checkBoxDemo = driver.findElement(By.xpath("//label//input[@id='isAgeSelected']"));
       WebElement checkBoxMsg = driver.findElement(By.xpath("//*[.=\"Success - Check box is checked\" ]"));

        Assert.assertFalse(checkBoxMsg.isDisplayed(),"verify Success – Check box is checked  is NOT displayed ");

        checkBoxDemo.click();

        Assert.assertTrue(checkBoxMsg.isDisplayed(),"verify Success – Check box is checked  is displayed ");


    }
    @Test
    public void tc3() throws InterruptedException {

        WebElement checkAllBtn = driver.findElement(By.id("check1"));
        String checkAllBtnText = checkAllBtn.getAttribute("value");
        Assert.assertTrue(checkAllBtnText.contains("Check All"), "verify text is: Check All");

        checkAllBtn.click();
        WebElement checkAllEl1 = driver.findElement(By.xpath("(//*[@class='cb1-element'])[1]"));
        Assert.assertTrue(checkAllEl1.isSelected(), "verify Option 1 is selected");

        WebElement checkAllEl2 = driver.findElement(By.xpath("(//*[@class='cb1-element'])[2]"));
        Assert.assertTrue(checkAllEl2.isSelected(), "verify Option 2 is selected");

        WebElement checkAllEl3 = driver.findElement(By.xpath("(//*[@class='cb1-element'])[3]"));
        Assert.assertTrue(checkAllEl3.isSelected(), "verify Option 3 is selected");

        WebElement checkAllEl4 = driver.findElement(By.xpath("(//*[@class='cb1-element'])[4]"));
        Assert.assertTrue(checkAllEl4.isSelected(), "verify Option 4 is selected");

        Assert.assertTrue(checkAllBtn.getAttribute("value").contains("Uncheck All"), "verify text now is: Uncheck All");

        driver.quit();
    }

}
