package com.cybertek.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestingWikipedia {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("selenium webdriver");

        driver.findElement(By.name("go")).click();
        driver.findElement(By.xpath("//span[.= 'webdriver']")).click();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "Watir-webdriver";
        System.out.println(currentUrl);

        if(currentUrl.endsWith(expectedUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("Expected ending url: "  + expectedUrl);
            System.out.println("Actual ending url: "  + currentUrl);
        }


        driver.quit();
    }
}
