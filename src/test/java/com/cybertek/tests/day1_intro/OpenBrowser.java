package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();//it makes chrome ready for automation

        WebDriver driver = new ChromeDriver();//crating object with an empty chrome.

        driver.get("https://www.cybertekschool.com/");//method that drives us to navigate into the page selected, making it ready for automation
    }
}
