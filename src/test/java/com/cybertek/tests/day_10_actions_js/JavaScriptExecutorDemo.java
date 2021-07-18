package com.cybertek.tests.day_10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
   driver.quit();

    }
    @Test
    public  void clickWithJS(){
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdown = driver.findElement(By.linkText("Dropdown"));

        //using JS executer object to click now:
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click", dropdown);
    }
    @Test
    public void typeWithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        String str = "Hello Disable input";

        //writing input in a disable box, only JS can do it
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + str + "')", inputBox);
    }
    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
       // driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for(int i = 0; i < 5; i++){

            Thread.sleep(1000);
            //scrolling down looping
            jse.executeScript("window.scrollBy(0,500)");
        }
        for (int i = 0; i < 5; i++){


            Thread.sleep(1000);
            //scrolling up looping
            jse.executeScript("window.scrollBy(0,-500)");
        }
    }
    @Test
    public void scrollToElement(){
        driver.get("https://www.amazon.es/");

        WebElement navToTop = driver.findElement(By.cssSelector(".navFooterBackToTopText"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scrolling directly to the element
        jse.executeScript("arguments[0].scrollIntoView(true);", navToTop);

        navToTop.click();
    }
}
