package com.cybertek.tests.day_13_pom;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){


            String username = ConfigurationReader.get("driver_username");
            String password = ConfigurationReader.get("driver_password");

            driver.findElement(By.id("prependedInput")).sendKeys(username);
            driver.findElement(By.id("prependedInput2")).sendKeys(password);

        }
}
