package com.cybertek.tests.day_12_properties_driver_test;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){

        String browserType = ConfigurationReader.get("browser");
        System.out.println(browserType);

        String url = ConfigurationReader.get("url");
        System.out.println(url);
    }
    @Test
    public void openBrowserWithConf() {
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get(username));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get(password)
                + Keys.ENTER);//we can use Keys.TAB as well since it works moving to the next step
    }

}
