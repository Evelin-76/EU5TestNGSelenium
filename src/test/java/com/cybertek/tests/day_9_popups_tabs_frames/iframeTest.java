package com.cybertek.tests.day_9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
       // driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //how to switch frames
        //1. Switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear before sendkeys
        driver.findElement(By.id("tinymce")).clear();
        //sending keys
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("Lucas");

        //goes back to first frame(main html)
        //useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2. Switching with Index
        driver.switchTo().frame(0);

        driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("Lucas with Index");

        //second way to switch parent
        driver.switchTo().parentFrame();


        //3.Using WebElement
        //locaitn ifrimw with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);

        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys(" Lucas with WebElement");

        }

        @Test
        public void test2() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/nested_frames");

            //Switching to frame top because is the parent
            driver.switchTo().frame("frame-top");
            //switching to frame middle where we want to work with
            driver.switchTo().frame("frame-middle");

            System.out.println(driver.findElement(By.id("content")).getText());

            //goes back to top frame(it is the parent frame of middle frame)
            //we can go back one level by level like this
            driver.switchTo().parentFrame();

            //switching right frame this time with index
            driver.switchTo().frame(2);

            //getting text
            System.out.println(driver.findElement(By.tagName("body")).getText());

            //getting back to main frame, it is the first or default frame
            //so we can access to botton frame that is a child of this frame with top frame as well
            driver.switchTo().defaultContent();

            //switch the frame we want to work with. Bottom this time by index
            driver.switchTo().frame(1);

            //getting text by tagname since it is the unique so it appears in first line
            System.out.println(driver.findElement(By.tagName("body")).getText());



        }
}
