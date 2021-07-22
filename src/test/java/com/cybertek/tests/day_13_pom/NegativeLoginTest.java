package com.cybertek.tests.day_13_pom;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

            driver.findElement(By.id("prependedInput")).sendKeys("user1");
            driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
            driver.findElement(By.id("_submit")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"verify url is 'https://qa1.vytrack.com'");
        }
}
