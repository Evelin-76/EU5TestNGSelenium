package com.cybertek.HomeWorks.eu2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Tc07 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='File Upload']")).click();

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "\\src\\test\\resources\\textFile.txt";
        String fullPath = projectPath + filePath;
        chooseFile.sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        String successMsg = driver.findElement(By.cssSelector(".example")).getText();

        Assert.assertEquals(successMsg,"File Uploaded!", "veryfy success msg is 'File Uploaded!'");

        driver.quit();
    }
}
