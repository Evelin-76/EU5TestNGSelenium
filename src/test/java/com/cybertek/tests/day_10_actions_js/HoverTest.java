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
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void homeworkTest() throws InterruptedException {

        List<WebElement> avatars = driver.findElements(By.cssSelector(".figure"));

        for (WebElement avatar : avatars) {
            Actions actions = new Actions(driver);
            actions.moveToElement(avatar).perform();
            Thread.sleep(2000);
            Assert.assertTrue(avatar.isDisplayed(),"verify if view link is displayed");
        }

    }

    @Test
    public void Tc1() throws InterruptedException {

        WebElement img1 = driver.findElement(By.xpath("(//*[@alt='User Avatar'])[1]"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(img1).perform();

        WebElement textIm5 = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(textIm5.isDisplayed(),"verify text 1 is displayed");
        Assert.assertTrue(textIm5.getText().equals("name: user1"),"verify text 1 is 'name: user1'");
    }
    @Test
    public void tc2() throws InterruptedException {

        for(int i = 1; i <= 3; i++){
            String Img = "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(Img));
            //another way to do it directly
          //  WebElement img = driver.findElement(By.xpath(("//img["+i+"]")));
            System.out.println(Img);
            String textXpath = "//h5[.='name: user" + i + "']";
            WebElement textIm = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Actions actions1 = new Actions(driver);
            actions1.moveToElement(img).perform();
            Assert.assertTrue(img.isDisplayed(),"verify text of all images" +i+ " are displayed");

        }
    }
}
