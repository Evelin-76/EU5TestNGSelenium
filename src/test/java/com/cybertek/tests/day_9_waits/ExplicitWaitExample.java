package com.cybertek.tests.day_9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1()  {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        WebElement element = driver.findElement(By.id("username"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

        element.sendKeys("Lucas");
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        //this case is different from @test 1 and 3. We locate first while page is loading the
        //text "Hello World" and latet we apply same approach this way below:
        WebElement element1 = driver.findElement(By.id("loading"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(element1));

        WebElement element = driver.findElement(By.id("finish"));
        System.out.println(element.getText());
    }
    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

        WebElement usernameInput = driver.findElement(By.id("username"));

        //how to wait explicitly? creating Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        usernameInput.sendKeys("Lucas");
    }
    @Test
    public void test4(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement((By.xpath("//*[.=\"Enable\"]"))).click();

        //finding inputBox
        WebElement inputBox = driver.findElement(By.xpath("//*[@type='text']"));

        //using explicit waits with right condition(elementToBeClickable) for sendKeys and go on
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox)).sendKeys("Lucas");




    }
}
