package com.cybertek.HomeWorks.eu2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Tc08 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");


        driver.findElement(By.linkText("Autocomplete")).click();

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        WebElement country = driver.findElement(By.xpath("//*[.='United States of America']"));
        String usa = country.getText();
        System.out.println(usa);
        String expectedCountry = "United States of America";

        Assert.assertEquals(usa,expectedCountry, "verify country is 'United States of America'");
    }
}
