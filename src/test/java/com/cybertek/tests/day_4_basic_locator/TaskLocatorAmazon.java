package com.cybertek.tests.day_4_basic_locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskLocatorAmazon {

    //go to amazon.es
    //search for "selenium"
    //click search button
    //verify 1-48 de más de 1.000 resultados para "selenium"

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.es/");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium" + Keys.ENTER);

        WebElement resultText1 = driver.findElement(By.xpath("//span[@dir='auto'][1]"));
        String actualResult1 = resultText1.getText();

        WebElement resultText2 = driver.findElement((By.xpath("//span[@dir='auto'][3]")));
        String actualResult2 = resultText2.getText();

        String finalResult = actualResult1 + " " + actualResult2;

     String expectedResult = "1-48 de más de 1.000 resultados para \"selenium\"";

     if(finalResult.equals(expectedResult)){
         System.out.println("PASS");
     }else {
         System.out.println("FAIL");
         System.out.println("Actual result: " + actualResult1 + " Expected result: " + expectedResult);
     }
    driver.quit();
    }
}
