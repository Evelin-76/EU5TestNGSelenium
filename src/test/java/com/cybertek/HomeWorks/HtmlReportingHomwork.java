package com.cybertek.HomeWorks;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.annotations.Test;

public class HtmlReportingHomwork extends TestBase {
    /*
    open the chrome
    go to qa1.vytrack
    login as a sales manager
    navigate to customers -> contacts
    click on email mbrackstone9@example.com
    verify that full name is Mariam Brackstone
    verify that email is mbrackstone9@example.com
    verify that phone number is +198982323434
     */
    @Test
    public void test1(){
        extentLogger = report.createTest("Customers contacts");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("")
        loginPage.loginAsSaleManager();
    }

}
