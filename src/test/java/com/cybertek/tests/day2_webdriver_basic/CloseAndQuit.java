package com.cybertek.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(2000);

        driver.close();//close current tab in 2 seconds

        driver = new ChromeDriver();//we open again a new browser in order to go on automating Selenium in next lines

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

      //  driver.close();//close current tab but not the new tab -->/open_new_tab(is a new tab in our last web

        //we can close every tab and everything like follow:

        driver.quit();
    }
}
