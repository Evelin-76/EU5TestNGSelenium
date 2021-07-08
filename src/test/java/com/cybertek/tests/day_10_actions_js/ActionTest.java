package com.cybertek.tests.day_10_actions_js;

import com.cybertek.utilities.AcceptCookies;
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

public class ActionTest {

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
    public void hoverTest(){
        driver.get("http://practice.cybertekschool.com/hovers");

        //locating element
        WebElement img = driver.findElement(By.tagName("img"));

        //Actions-->class that contains all the user interaction
        //creating an object to work with related to the element located
        // passint (driver) as a constructor
        Actions actions = new Actions(driver);

        //perform the action, moving the mouse on that element in web page
        actions.moveToElement(img).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));


    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        //IF THERE ARE COOKIES BLOCKING THE PAGE VIEW WE CAN USE THIS
        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies= driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        //Thread.sleep(2000);
        if(acceptAndClose.size() > 0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()> 0){
            acceptCookies.get(0).click();
        }

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement((By.id("droptarget")));

        //action short way:
        //actions.dragAndDrop(source,target).perform();

        //same action long way.It is used if we want to change some request if we have options:
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

        //HERE THE ELEMENT CHANGE CONTENT TEXT WHEN IT IS NOT PAINTED OR WE MISTAKE WHEN WE PUT
        //SOURCE ON TARGET OR GIVES ANOTHER MSG WHEN WE PUT IT ON SUCCESSFULLY
        //WE TRY TO ASSESS MSGS ARE NOT SAME BUT I COULDN'T GET IT
      //  WebElement painted = driver.findElement(By.xpath("//div[@class='k-header painted']"));
        // String msg = target.getText();
       // String msg1 = painted.getText();
        //String actualMsg = "You did great!";
        //System.out.println(msg);
       // System.out.println(msg1);
        //Assert.assertTrue(painted.equals(actualMsg),"verify msg is 'You did great!'");

    }

}
