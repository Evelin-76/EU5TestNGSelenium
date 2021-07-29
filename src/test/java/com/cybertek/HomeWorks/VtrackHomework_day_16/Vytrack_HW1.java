package com.cybertek.HomeWorks.VtrackHomework_day_16;

import com.cybertek.pages.AllCalendarEvents;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.ref.SoftReference;

public class Vytrack_HW1 extends TestBase {

    @Test
    public void tc1(){

        extentLogger = report.createTest("Options test verification");

        extentLogger.info("login as storeManager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("navigate to Activities / Calendar Events");
        new DashboardPage().navigateToModule("Activities","Calendar Events");
        extentLogger.info("Getting options text");
        String optionsText = new AllCalendarEvents().option.getText();
        extentLogger.info("verify text is Options");
        Assert.assertEquals(optionsText,"Options");

        extentLogger.pass("PASS");
    }
    @Test
    public void tc2() {

        extentLogger = report.createTest("Number page verification");

        extentLogger.info("login as storeManager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("navigate to Activities / Calendar Events");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        extentLogger.info("getting attribute text");
        String pageNumber = new AllCalendarEvents().pageNumber.getAttribute("value");

        extentLogger.info("verify value text is 1");
        Assert.assertEquals(pageNumber,"1");

        extentLogger.pass("PASS");
    }
    @Test
    public void tc3(){

        extentLogger = report.createTest("Verify View Per Page value");

        extentLogger.info("login as store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("navigate to Activities / Calendar Events");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        extentLogger.info("getting View Per Page value text");
        String viewPerPageValue = new AllCalendarEvents().ViewPerPage.getAttribute("data-size");

        extentLogger.info("verify View Per Page number is 25");
        Assert.assertEquals(viewPerPageValue,"25","verify View Per Page is 25");

        extentLogger.pass("PASS");
    }
    @Test
    public void tc4() throws InterruptedException {

        extentLogger = report.createTest("Verify that number of calendar events " +
                "(rows in the table) is equals to number of records");

        extentLogger.info("login as store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("navigate to Activities / Calendar Events");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
      //  System.out.println(allCalendarEvents.getAllRowsNumber());

       // System.out.println(allCalendarEvents.numberOfPages.getText());

      //  System.out.println(allCalendarEvents.TotalOfRecord.getText());
      //  String num =allCalendarEvents.numberOfPages.getText();
      //  num = num.replace("Of ","");
      //  num = num.replace(" |","");

     //   System.out.println(num);

      //  Integer i = Integer.valueOf(num);
      //  System.out.println(i);

        allCalendarEvents.lastPageRows();

     //   String intToString = Integer.toString(allCalendarEvents.getAllRowsNumber());
     //   String allNumberRows = intToString;
     //   String totalRecords = allCalendarEvents.TotalOfRecord.getText();
     //   Assert.assertEquals(totalRecords,allNumberRows,"verify row number is equal to record number");

        // ExcelUtil numberEvents = new ExcelUtil("");
       // System.out.println(numberEvents.rowCount());


    }

}
