package com.cybertek.tests.day_9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/windows");
        //get the title
        System.out.println("Title b4 window = " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

      //  System.out.println("Title after window = " + driver.getWindowHandle());-->it takes reference

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }
        System.out.println("driver.getTitle() after new window = " + driver.getTitle());
    }
    @Test
    public void moreThan2Windows(){
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Title after window = " + driver.getWindowHandle());

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        //loop through each window
        for (String handle : windowHandles) {
            //one by one it is changing
            driver.switchTo().window(handle);
            //whenever your title equals to youer expected window title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }
        }
        System.out.println("After Switch " + driver.getTitle());
    }
}
