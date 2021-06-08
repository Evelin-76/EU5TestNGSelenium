package com.cybertek.tests.day_3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) throws InterruptedException {

         /*Veryfy URL changed
        -open chrome browser
        -go to URL http://practice.cybertekschool.com/forgot_password Lint to an external site
        -enter any e-mail
        -verify that email is dispalyed in the input box
        -Click on Retrieve password
        -URL changed to http://practice.cybertekschool.com/email_sent
        -verify appear a message says 'Your e-mail's been sent!'
         */

     WebDriver driver = WebDriverFactory.getDriver("chrome");
     driver.get("http://practice.cybertekschool.com/forgot_password");


        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "miperro@perrito.com";
        emailInputBox.sendKeys(expectedEmail);

        //verify that emal is diplaye in the input box

        //somehow we should get tex from web elements
        //two main ways to get txt from webelements
        //1.getTesx()--> it will work %99 and it will return string.NOT FOR INPUT BOXES
        //2.getAtribute()--> second way of gettin text especially input boxes.FOR INPUT BOXES

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("expectedEmail = " + expectedEmail);

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
         WebElement retrievePasswoerdButton = driver.findElement(By.id("form_submit"));
        retrievePasswoerdButton.click();

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));

        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationMessage.getText();

        System.out.println(confirmationMessage.getText());
        System.out.println(expectedMessage);

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage: " + expectedEmail);
            System.out.println("actualMessage: " +  actualEmail);
        }
        driver.quit();
    }
}
