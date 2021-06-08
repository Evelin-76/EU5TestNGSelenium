package com.cybertek.tests.day_3_webelement_intro;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchangedForgot__password {

    public static void main(String[] args) throws InterruptedException {

        /*Veryfy URL chaged
        -open chrome browser
        -go to URL http://practice.cybertekschool.com/forgot_password
        -Click on Retrieve password
        -verify that URL changed to http://practice.cybertekschool.com/email_sent
         */

        WebDriver driver = WebDriverFactory.getDriver("chRome");//toLowerCase ready

        driver.get("http://practice.cybertekschool.com/email_sent");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("migato@gatito.com");

        //click retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        Thread.sleep( 2000);

        retrievePasswordButton.click();
        Thread.sleep(2000);

        String expectieddUrl = "http://practice.cybertekschool.com/email_sent";
          String firstdUrl = driver.getCurrentUrl();

        //verify that url did not change
        if(firstdUrl.equals(expectieddUrl)){
            System.out.println("PASS");
        }else{//if it fails it will print fail messages below
            System.out.println("FAIL");
            System.out.println("expectedURL" + expectieddUrl);
            System.out.println("actualURL" + firstdUrl);
        }
         driver.quit();

    }
}
