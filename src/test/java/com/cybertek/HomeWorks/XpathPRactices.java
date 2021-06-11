package com.cybertek.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class XpathPRactices {

     public static void main(String[] args) {

    WebDriver driver = WebDriverFactory.getDriver("Chrome");
    driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement elementHome = driver.findElement(By.xpath("//nav//a"));
        System.out.println(elementHome.getText());

        WebElement elementHeader = driver.findElement(By.xpath("//h2"));
         System.out.println(elementHeader.getText());

         WebElement elementEmail = driver.findElement(By.xpath("//*[@for='email']"));
         System.out.println(elementEmail.getText());

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("felipe@feliz.com");

        driver.findElement(By.xpath("//*[@id='form_submit']")).click();

         String currentUrl = driver.getCurrentUrl();
         String expectedUrl= "http://practice.cybertekschool.com/email_sent";

         WebElement confMss = driver.findElement(By.xpath("//*[@name='confirmation_message']"));
         String confirmationMessage = confMss.getText();
         String expectedMessage = "Your e-mail's been sent!";


         if(currentUrl.equals(expectedUrl) && confirmationMessage.equals(expectedMessage)){
             System.out.println("PASS");
         }else{
             System.out.println("FAIL");
             System.out.println("Actual url: " + currentUrl);
             System.out.println("Expected url: " + expectedUrl);
             System.out.println("Actual message: " + confirmationMessage);
             System.out.println("Expected message: " + expectedMessage);
         }
        driver.quit();
    }

}
