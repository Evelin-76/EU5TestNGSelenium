package com.cybertek.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPs4Drop {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

       WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
       searchBox.sendKeys("ps4");
       Thread.sleep(6000);
        WebElement card = driver.findElement(By.id("issDiv4"));//locator for gift card of dropdown menu
        String text = card.getAttribute("textContent");
        System.out.println(text);
        card.click();
        driver.quit();



      //  WebDriver driver = WebDriverFactory.getDriver("chrome");
       // driver.get("https://www.amazon.com/");

      //  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ps4");
       // Thread.sleep(5000);
       // WebElement card = driver.findElement(By.id("issDiv4)"));
       // Thread.sleep(5000);
    }



}
