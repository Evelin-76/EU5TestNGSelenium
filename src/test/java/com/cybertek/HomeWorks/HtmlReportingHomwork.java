package com.cybertek.HomeWorks;

import com.cybertek.pages.ContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
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
    public void test1() throws InterruptedException {
        extentLogger = report.createTest("Customers contacts");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter sale manager valid credentials and click login button");
        loginPage.loginAsSaleManager();

        extentLogger.info("Navigate to Customers / Contacts");
        DashboardPage navigate = new DashboardPage();
        navigate.navigateToModule("Customers", "Contacts");

        extentLogger.info("Click on mail");
        ContactPage createContactPage = new ContactPage();
        Thread.sleep(3000);
        createContactPage.email.click();

        extentLogger.info("Verify name");
        String expectedFullName = "Mariam Brackstone";
        String actualFullname = createContactPage.fullName.getText();
        Assert.assertEquals(actualFullname,expectedFullName,"Verify full name is Mariam Brackstone");

        extentLogger.info("Verify mail in Contact Info");
        String expectedEmail = "mbrackstone9@example.com";
        Assert.assertEquals(createContactPage.emailMariam.getText(),expectedEmail,"Verify " +
                "email is mbrackstone9@example.com");

        extentLogger.info("Verify phone number");
        Assert.assertEquals(createContactPage.phoneNumber.getText(),"+18982323434","Verify phone number is +18982323434");

        extentLogger.pass("PASS");
    }
}
