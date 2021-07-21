package com.cybertek.MyPractices;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class SwitchWindow {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
    }
    @AfterMethod
    public void tearDown(){
     //   driver.quit();
    }
    @Test
    public void getTitle() throws InterruptedException {

       driver.get("https://norfipc.com/inf/javascript-abrir-nueva-ventana-navegador.html");
       String firstWinTitle = driver.getTitle();
        System.out.println(firstWinTitle);

        WebElement MeGusta = driver.findElement(By.xpath("//*[.=\"Me Gusta\"]"));
        MeGusta.click();

        String newWindowOpened = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(newWindowOpened)) {
                driver.switchTo().window(windowHandle);
            }
        }
        String currentWinTitle = driver.getTitle();
        System.out.println(currentWinTitle);

        Assert.assertFalse(currentWinTitle.equals(firstWinTitle),"Verify Titles are not same");
    }
}
