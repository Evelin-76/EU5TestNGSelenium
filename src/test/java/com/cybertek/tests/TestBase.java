package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    //this class is for used for starting and building reports
    protected static ExtentReports report;
    //this class is used for create HTML file
    protected static ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs, authors test steps
    protected static ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
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
    @AfterTest
    public void tearDownTest(){
        //this is when the report is actually created
        report.flush();
    }

    @BeforeMethod
    public void setUp(){
        driver =  Driver.get();
     //   driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));
    }

    //IT IS CLOSING BROWSER AFTER FIRST TC
    // IT IS USEFUL BECAUSE WE WANT OUR TCs INDEPENDENT FORM EACH OTHER
    //ITestResult class describes the result of a test in TestNG
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException, InterruptedException {
        //if test fails
        if(result.getStatus() == ITestResult.FAILURE){
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put sinside the report
            extentLogger.fail(result.getThrowable());
        }
      //  Thread.sleep(2000);
       // Driver.closeDriver();
    }
//IT is running all of our TCs pointed by same object applying singleton design
//    @AfterClass // @AfterMethod
//    public void tearDownTest(){
//        Driver.closeDriver();
//    }
}
