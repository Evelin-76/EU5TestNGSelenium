package com.cybertek.tests.day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver drive = new ChromeDriver();

        drive.get("http://practice.cybertekschool.com/forgot_password");

        //System.out.println(drive.getTitle());//getting title directly with Selenium
      String title = drive.getTitle();//another way to getting title with Selenium
        System.out.println("title = " + title);
        //System.out.println(title);

        String currentUrl = drive.getCurrentUrl();//name of web page

        System.out.println("currentUrl = " + currentUrl);
//source code of page but we wont use it
        String pageSource = drive.getPageSource();
        System.out.println("pageSource = " + pageSource);
        


    }
}
