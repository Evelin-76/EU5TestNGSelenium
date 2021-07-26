package com.cybertek.tests.day_14_ExtendReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtendsDemoTest {

    //this class is for used for starting and building reports
    ExtentReports report;
    //this class is used for create HTML file
    ExtentHtmlReporter htmlReporter;
    //this will defint a test, enables adding logs, authors test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
    //initialize the class
        report = new ExtentReports();

        //create a report path:
        //1. this is the project path where our project is locator:
        String projectPath = System.getProperty("user.dir");
        //this is my file path for report, it is where my project path is dynamic
        String path = projectPath + "/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object and create the connection between them
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));


    }
    @Test //THIS IS THE ONLY DYNAMIC PART IN OUR REPORT. THE REST WILL BE SAME
        public void test1(){//after execution we will have the test-output folder
        //inside we will have the report.html created here

            //give name to current test
             extentLogger = report.createTest("TC123 Login as Driver Test");

             //test steps here:
            extentLogger.info("Open Chrome Browser");
            extentLogger.info("Go to url");
            extentLogger.info("Enter driver user name and password");
            extentLogger.info("click login button");
            extentLogger.info("Verify logged in");
            //pass() --> marks the test case as passed
            extentLogger.pass("TC123 is passed");
    }

    @AfterMethod
    public void tearDown(){
        //this is when the report is actually created
        report.flush();
    }
}
