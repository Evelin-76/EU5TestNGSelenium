package com.cybertek.HomeWorks.VtrackHomework_day_16;

import com.cybertek.pages.AllCalendarEvents;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.ref.SoftReference;
import java.util.List;

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
        Thread.sleep(1000);
        System.out.println(allCalendarEvents.getLastNumberOfPageString());
        System.out.println(allCalendarEvents.getLastNumberPage());

        Thread.sleep(2000);
        System.out.println(allCalendarEvents.TotalOfRecord.getText());
        System.out.println(allCalendarEvents.getAllRecordsString());
        System.out.println(allCalendarEvents.getTotalRecords());

        Thread.sleep(2000);
       allCalendarEvents.lastCellInfoIndex.getAttribute("data-column-label");
        // allCalendarEvents.lastPageRows();

       // System.out.println(allCalendarEvents.counterRecord.getText());


        //  System.out.println(allCalendarEvents.getAllRowsNumber());

       // System.out.println(allCalendarEvents.numberOfPages.getText());

      //  System.out.println(allCalendarEvents.TotalOfRecord.getText());
      //  String num =allCalendarEvents.numberOfPages.getText();
      //  num = num.replace("Of ","");
      //  num = num.replace(" |","");

     //   System.out.println(num);

      //  Integer i = Integer.valueOf(num);
      //  System.out.println(i);
       // Thread.sleep(2000);
       // allCalendarEvents.lastPageRows();

     //   String intToString = Integer.toString(allCalendarEvents.getAllRowsNumber());
     //   String allNumberRows = intToString;
     //   String totalRecords = allCalendarEvents.TotalOfRecord.getText();
     //   Assert.assertEquals(totalRecords,allNumberRows,"verify row number is equal to record number");

        // ExcelUtil numberEvents = new ExcelUtil("");
       // System.out.println(numberEvents.rowCount());


    }
    @Test
    public void tc5() throws InterruptedException {
        extentLogger = report.createTest("Verify all calendar events are selected");

        extentLogger.info("login as store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        extentLogger.info("navigate to Activities / Calendar Events");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        extentLogger.info("click check box for select all options");
        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        Thread.sleep(1000);
        allCalendarEvents.mainCheckBox.click();

        extentLogger.info("verifying all boxes are selected");
        System.out.println(allCalendarEvents.allCheckBoxesSelected());
        boolean expecetedResoltisSelected = true;
        boolean actualResultIsSelected = allCalendarEvents.allCheckBoxesSelected();

        Assert.assertEquals(actualResultIsSelected,expecetedResoltisSelected,
                "Verify all checkboxes are selected");

        extentLogger.pass("PASS");


    }

}
