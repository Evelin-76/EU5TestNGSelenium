package com.cybertek.tests.day_14_ExtendReports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest() {
        //name of the test
        extentLogger = report.createTest("Wrong password test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter valid username: User1");
        loginPage.usernameInput.sendKeys("User1");

        extentLogger.info("Enter wrong password: somepassword");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("Click login button");
        loginPage.loginButton.click();


//            driver.findElement(By.id("prependedInput")).sendKeys("user1");
//            driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
//            driver.findElement(By.id("_submit")).click();
        extentLogger.info("Verify page Url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong password Test is passed");
    }

    @Test
    public void wrongUsernameTest() {

        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter wrong username: someusername");
        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter valid password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();

        extentLogger.info("Verify Page Url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("PASSED");
    }

}
