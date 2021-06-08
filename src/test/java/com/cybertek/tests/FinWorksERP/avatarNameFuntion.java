package com.cybertek.tests.FinWorksERP;

import com.cybertek.utilities.WebDriverFactory;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class avatarNameFuntion {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://qa.finworkserp.com/web/login#action=120&active_id=channel_inbox");


        WebElement emailInputBox = driver.findElement(By.id("login"));
        String expectedEmail = "posmanager11@info.com";
        emailInputBox.sendKeys(expectedEmail);

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        String expectedPassword = "posmanager";
        passwordInputBox.sendKeys(expectedPassword);

        WebElement logginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        logginButton.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
