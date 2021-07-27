package com.cybertek.tests.day_15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

//this is the homework HtmlReportingHomwork done by Jamal
public class verifyContactinfoTest extends TestBase {

    @Test
    public void  contactDetailsTest() {

        extentLogger = report.createTest("Contact Info Verification");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salemanager_username");
        String password = ConfigurationReader.get("salemanager_password");
        extentLogger.info("usename:" + username);
        extentLogger.info("password:" + password);
        extentLogger.info("Login as sales manager");
        loginPage.login(username,password);

        //here we did not create an object because we are using the method for only one
        //time to navigate to module
        extentLogger.info("Navigate to-> Customers/Contacts");
       new DashboardPage().navigateToModule("Customers","Contacts");

       extentLogger.info("Click on mbrackstone9@example.com");
       ContactPage contactPage = new ContactPage();
       contactPage.waitUntilLoaderScreenDisappear();
       contactPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();
        extentLogger.info("Verify full name is " + expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"Verify full name");

        extentLogger.info("Verify mail is mbrackstone9@example.com");
        String expectedEmail = "mbrackstone9@example.com";
        Assert.assertEquals(contactInfoPage.email.getText(),expectedEmail,"verify email");

        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phoneNumber.getText(),"+18982323434", "verify phone number");

        extentLogger.pass("PASS");
    }

}
