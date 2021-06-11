package com.cybertek.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Locale;

public class TestingEbay {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

       //driver.navigate().to("https://www.ebay.es/");
       driver.get("https://www.ebay.es/");


        WebElement searchBox = driver.findElement(By.cssSelector("[type='text']"));
        searchBox.sendKeys("samsung");
        WebElement inputDropDown = driver.findElement(By.cssSelector("[type='submit']"));
        inputDropDown.click();
        WebElement getResult = driver.findElement(By.xpath("(//span[@class='BOLD'])[14]"));
        String text = getResult.getText();
        System.out.println("Number of result: " + text);

        String title = driver.getTitle();
        String samsung = "samsung";

        if(title.contains(samsung.toLowerCase())) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("Expected Title: "  + samsung);
            System.out.println("Actual Title: "  + title);
        }
        driver.quit();
    }




    }
