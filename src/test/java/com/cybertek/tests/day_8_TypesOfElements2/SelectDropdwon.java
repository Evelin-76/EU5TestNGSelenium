package com.cybertek.tests.day_8_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdwon {

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
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        //create  Select object by passing that elements as a constructor
        Select stateDropdwon = new Select(dropdownElement);
        //getting all elements/options in arrayList
        List<WebElement> options = stateDropdwon.getOptions();
        //printing size of elements
        System.out.println("options.size() = " + options.size());
        //printing every text element
        for (WebElement option : options) {
            System.out.println(option.getText());

        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdwon = new Select(dropdownElement);

        //verify that fors selection is Selact a state
        String expectedOption = "Select a State";
        String actualOption = stateDropdwon.getFirstSelectedOption().getText();
        System.out.println(actualOption);

        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //how to select option form dropdown
        //select using VISIBLE TEXT
        Thread.sleep(2000);
        stateDropdwon.selectByVisibleText("Virginia");//value of element visible is Virginia

        expectedOption = "Virginia";
        actualOption = stateDropdwon.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption,"verify first selection");

        //Select USING INDEX
        Thread.sleep(2000);
        stateDropdwon.selectByIndex(51);
        expectedOption = "Wyomingg";//it falis because it is not rigth written
        actualOption = stateDropdwon.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption,"verify first selection");

        //Select USING VALUE
        stateDropdwon.selectByValue("TX");//locating by value = TX
        expectedOption = "Texas";
        actualOption = stateDropdwon.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption,"verify first selection");


    }
}
