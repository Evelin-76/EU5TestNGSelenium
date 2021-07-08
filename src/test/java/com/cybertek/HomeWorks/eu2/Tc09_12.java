import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Tc09_12 {

    /*//This method will provide data to any test method that declares that its Data Provider
    //is named "test1"
    @DataProvider(name = "test1")
    public Object[][] createData1() {
    return new Object[][] {
   { "Cedric", new Integer(36) },
   { "Anne", new Integer(37)},
    };
    }

    //This test method declares that its data should be supplied by the Data Provider
    //named "test1"
    @Test(dataProvider = "test1")
    public void verifyData1(String n1, Integer n2) {
    System.out.println(n1 + " " + n2);
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test09() {

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Status Codes")).click();

        driver.findElement(By.linkText("200")).click();

        WebElement msg = driver.findElement(By.xpath("//p"));

        String msgCode200 = msg.getText();

        Assert.assertTrue(msgCode200.contains("This page returned a 200 status code."),
                "verify msg contains 'This page returned a 200 status code.'");
    }
    @Test
    public void test010() {

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Status Codes")).click();

        driver.findElement(By.linkText("301")).click();

        WebElement msg = driver.findElement(By.xpath("//p"));

        String msgCode300 = msg.getText();

        Assert.assertTrue(msgCode300.contains("This page returned a 301 status code."),
                "verify msg contains 'This page returned a 301 status code.'");
    }
    @Test
    public void test11() {

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Status Codes")).click();

        driver.findElement(By.linkText("404")).click();

        WebElement msg = driver.findElement(By.xpath("//p"));

        String msgCode404 = msg.getText();

        Assert.assertTrue(msgCode404.contains("This page returned a 404 status code."),
                "verify msg contains 'This page returned a 200 status code.'");
    }
    @Test
    public void test12() {

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Status Codes")).click();

        driver.findElement(By.linkText("500")).click();

        WebElement msg = driver.findElement(By.xpath("//p"));

        String msgCode500 = msg.getText();

        Assert.assertTrue(msgCode500.contains("This page returned a 500 status code."),
                "verify msg contains 'This page returned a 200 status code.'");
    }
    @Test//THIS WAY IS NOT APPROPIATE DUE ALL IS TOGETHER SO ONCE CODE FAILS IT WONT RUN THE REST
    public void CheckMsg(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Status Codes")).click();

        driver.findElement(By.linkText("200")).click();

        WebElement msg1 = driver.findElement(By.xpath("//p"));

        String msgCode200 = msg1.getText();

        Assert.assertTrue(msgCode200.contains("This page returned a 200 status code."),
                "verify msg contains 'This page returned a 200 status code.'");

        driver.navigate().back();

        driver.findElement(By.linkText("301")).click();

        WebElement msg2 = driver.findElement(By.xpath("//p"));

        String msgCode300 = msg2.getText();

        Assert.assertTrue(msgCode300.contains("This page returned a 301 status code."),
                "verify msg contains 'This page returned a 301 status code.'");

        driver.navigate().back();

        driver.findElement(By.linkText("404")).click();

        WebElement msg3 = driver.findElement(By.xpath("//p"));

        String msgCode404 = msg3.getText();

        Assert.assertTrue(msgCode404.contains("This page returned a 404 status code."),
                "verify msg contains 'This page returned a 200 status code.'");

        driver.navigate().back();

        driver.findElement(By.linkText("500")).click();

        WebElement msg4 = driver.findElement(By.xpath("//p"));

        String msgCode500 = msg4.getText();

        Assert.assertTrue(msgCode500.contains("This page returned a 500 status code."),
                "verify msg contains 'This page returned a 200 status code.'");
    }
}