package com.cybertek.tests.day_16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.tests.day_12_properties_driver_test.LoginTest;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] UserData (){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx",
                "QA3-short");
        String [][] dataArray = qa3short.getDataArrayWithoutFirstRow();
        return dataArray;
    }

    @Test(dataProvider = "UserData")
    public void test1(String username, String password, String firstName, String lastName){
 //       System.out.println("Username: " + username + " password: " + password
 //       + " firstname: " + firstname + " lastname: " + lastname);
        extentLogger = report.createTest("Test " + firstName + " " + lastName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullname = dashboardPage.getUserName();
        String expectedFullname = firstName + " " + lastName;

        Assert.assertEquals(actualFullname,expectedFullname,"Veryfy full name");
        extentLogger.pass("PASS");
    }

}
