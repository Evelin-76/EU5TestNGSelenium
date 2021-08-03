package com.cybertek.tests.day_8_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));//it is an arrayList
        //we can to look for a list of elements.they are 6 and we located them for a shared value
        //we can use arrayList methods as get the .size
        System.out.println("buttons.size() = " + buttons.size());

        //verifying size is correct
        Assert.assertEquals(buttons.size(),6,"verify button size");

        //print the text af every element in the list we iterate with for loop-->iter +ctl+enter
        for (WebElement button : buttons) {
           System.out.println(button.getText());
        //    System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(),"verify buttons are diplayed");
        }
        //click the second button. it has the index 1 in the arrayList
        buttons.get(1).click();
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //passing locater which does not exist returns wont throw NoSuchElement
        // size will be 0
        List<WebElement> buttons = driver.findElements(By.tagName("buttonSADFas"));

    }

}
