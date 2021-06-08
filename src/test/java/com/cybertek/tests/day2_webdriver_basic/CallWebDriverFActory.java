package com.cybertek.tests.day2_webdriver_basic;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFActory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driverC = WebDriverFactory.getDriver("chrome");

        WebDriver driverF = WebDriverFactory.getDriver("firefox");

        driverC.get("https://www.google.com");
        Thread.sleep(3000);
        driverC.close();

        driverF.get("https://www.google.com");
        Thread.sleep(5000);
        driverF.close();
    }
}
