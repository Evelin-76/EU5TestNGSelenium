package com.cybertek.tests.day_4_basic_locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("firefox");

        //make browser fullscreen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameBox = driver.findElement(By.name("full_name"));
        fullNameBox.sendKeys("My Full Name Here");

        //put some email and sing up button: Long way to do it assigning name. Better way
        //  WebElement emailBox = driver.findElement(By.name("email"));
        //  emailBox.sendKeys("myfullname@gmail.com");

          //short cut for add information in boxes but it won't be assigned to a reference so
        //we cannot modified by name value
        driver.findElement(By.name("email")).sendKeys("myfullname@gmail.com");

          WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
          signUpButton.click();
          driver.quit();

    }
}
