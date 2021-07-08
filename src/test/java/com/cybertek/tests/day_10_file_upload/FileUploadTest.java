package com.cybertek.tests.day_10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
         driver.quit();
    }
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));
        //copy path and paste (keeping shift pressed in windows and clicking right button it appears
        //in spanish as sth copiar ruta....It is the absolute path
        // this was the route copied first:"C:\Users\Evelin\Documents\file.txt"
        //and when we paste it add double quotes and slashes at the beginning and ending
        //We have to remove the "\ from the beginning and ending to make it works.
        chooseFile.sendKeys("C:\\Users\\Evelin\\Documents\\file.txt");

        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
      //  System.out.println(actualFileName);
        //verify file name is the uploaded file two ways:
       // Assert.assertTrue(actualFileName.equals("file.txt"),"verify file text is 'file.txt'");
        Assert.assertEquals(actualFileName, "file.txt");

    }
    @Test
    public void test2(){

        //HERE WE CREATED A FILE IN RESOURCES FOR THE PROJECT SO COLLEGUES CAN WORK IF WE PUSH PROJECT
        //TO REMOTE GITHUB AND PUSH IT. RESOURCES IS CREATED FROM MAIN TEST/DIRECTORY/SELECT RESOURCES/
        //CREATE THE FILE
        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));

        //sending file with sendKeys method separetly.This is the root of directory can be dynamic:
        String projectPath = System.getProperty("user.dir");
       //this is the route for complete the path, chose clicking right button mouse on texFile.txt
        //and selecting copy path/path from content root--> I changed the direction of slash from / to \
        //to make it works or it won't run in windows.I ADDED the first slash manually -->\\
        String filePath = "\\src\\test\\resources\\textFile.txt";

        String fullPath = projectPath + filePath;
        // chooseFile.sendKeys(fullPath);
        chooseFile.sendKeys(fullPath);
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
         //verify file name is the uploaded file two ways:
        // Assert.assertTrue(actualFileName.equals("file.txt"),"verify file text is 'file.txt'");
        Assert.assertEquals(actualFileName, "textFile.txt");
    }
}
