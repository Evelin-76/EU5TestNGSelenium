package com.cybertek.tests.day_3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {
    public static void main(String[] args) throws InterruptedException {
        /*Veryfy URL not chaged
        -open chrome browser
        -go to URL http://practice.cybertekschool.com/forgot_password
        -Click on Retrieve password
        -verify that URL did not changed
         */

        //open chorme browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password  Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save expected url before clicking button
        String expectedUrl = driver.getCurrentUrl();

        //click on Retrieve password
        //WebElement --> Interface that represent elements on the webpage
        //findElement --> method used to find element on page
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //save actual url before clicking button
        String actualUrl = driver.getCurrentUrl();

        //verify that url did not change
         if(expectedUrl.equals(actualUrl)){
                    System.out.println("PASS");
                }else{
                    System.out.println("FAIL");
                }
         Thread.sleep(2000);
         driver.quit();

    }
}
