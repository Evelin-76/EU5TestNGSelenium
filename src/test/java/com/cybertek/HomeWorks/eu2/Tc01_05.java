package com.cybertek.HomeWorks.eu2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Tc01_05 {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void tc1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

        WebElement msg = driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));

        String msgInvalidInput = msg.getText();
        String msgExpectedInvInput = "The date of birth is not valid";

        Assert.assertTrue(msgInvalidInput.equals(msgExpectedInvInput), "Verify invalid " +
                "msg is 'The date of birth is not valid'");
    }
    @Test
    public void tc2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        List<WebElement> languages = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']"));

        for (WebElement language : languages) {

            Assert.assertTrue(language.isDisplayed(),"verify all c++,java and javascript are displayed");
        }
    }
    @Test
    public void tc3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.name("firstname")).sendKeys("A");

        WebElement msg = driver.findElement(By.xpath("//small[@data-bv-for='firstname'][2]"));
        String errorMsg = msg.getText();
        String msgExpected = "first name must be more than 2 and less than 64 characters long";

        Assert.assertTrue(errorMsg.equals(msgExpected), "verify one single character entered in " +
                "the box gives 'first name must be more than 2 and less than 64 characters long' msg");
    }
    @Test
    public void tc4(){

            driver.get("https://practice-cybertekschool.herokuapp.com/");

            driver.findElement(By.xpath("//a[.='Registration Form']")).click();

            driver.findElement(By.name("lastname")).sendKeys("B");

            String errorMsg = (driver.findElement(By.xpath("//small[@data-bv-for='lastname'][2]"))).getText();
            String msgExpected = "The last name must be more than 2 and less than 64 characters long";

            Assert.assertTrue(errorMsg.equals(msgExpected), "verify one single character entered in " +
                    "the box gives 'The last name must be more than 2 and less than 64 characters long' msg");
    }
    @Test
    public void tc5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.name("firstname")).sendKeys("Luis");
        driver.findElement(By.name("lastname")).sendKeys("Enrique");
        driver.findElement(By.name("username")).sendKeys("Coacher");
        driver.findElement(By.name("email")).sendKeys("luisenrique@coacher.com");
        driver.findElement(By.name("password")).sendKeys("n1luisenrique");
        driver.findElement(By.name("phone")).sendKeys("571-555-6666");
        WebElement gender = driver.findElement(By.xpath("//*[@value='male']"));
        gender.click();
        driver.findElement(By.name("birthday")).sendKeys("01/02/2005");
        driver.findElement(By.name("department")).click();
        driver.findElement(By.xpath("//*[@value='TO']")).click();
        driver.findElement(By.name("job_title")).click();
        driver.findElement(By.xpath("//*[.='SDET']")).click();
        driver.findElement(By.cssSelector("#inlineCheckbox1")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        WebElement msg = driver.findElement(By.xpath("//p[contains(text(),'successfully')]"));
        String successMsg = msg.getText();
        String expectedMsg = "You've successfully completed registration!";

        Assert.assertTrue(successMsg.equals(expectedMsg),"verify msg is 'You've successfully completed registration!'");

    }
}
