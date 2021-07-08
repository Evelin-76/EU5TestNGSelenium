package com.cybertek.tests.day_10_actions_js;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class HoverTest {

    /**
     * provide before and after methods
     * http://practice.cybertekschool.com/hovers
     * hover over each image in the website looping/list of elements
     * verify each name: user text is displayed
     *
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void homeworkTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> avatars = driver.findElements(By.cssSelector(".figure"));

        for (WebElement avatar : avatars) {
            Actions actions = new Actions(driver);
            actions.moveToElement(avatar).perform();
            Thread.sleep(2000);
            Assert.assertTrue(avatar.isDisplayed(),"verify if view link is displayed");
        }
    }
}
