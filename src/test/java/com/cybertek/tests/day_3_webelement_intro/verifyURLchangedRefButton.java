package com.cybertek.tests.day_3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchangedRefButton {

    public static void main(String[] args) throws InterruptedException {

     /*Veryfy URL chaged
        -open chrome browser
        -go to URL http://practice.cybertekschool.com
        -Click on a button "A/B Testing"
        -verify that URL goes to http://practice.cybertekschool.com/abtest
         */

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    driver.get("http://practice.cybertekschool.com");
        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(2000);
        System.out.println("Homepage:" + actualUrl);

        //go to navigate other url linked with the page using its reference attribute
        WebElement abTesting = driver.findElement(By.xpath("//a[@href='/abtest']"));
        abTesting.click();

    driver.get("http://practice.cybertekschool.com/abtest");
        actualUrl = driver.getCurrentUrl();
        String expectedUrl = driver.getCurrentUrl();


        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");

            System.out.println("actualUrl: " + actualUrl);
            System.out.println("expectedUrl: " + expectedUrl);
        }
        driver.quit();
    }
}
