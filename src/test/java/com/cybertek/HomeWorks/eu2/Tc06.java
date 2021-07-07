package com.cybertek.HomeWorks.eu2;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Tc06{
    public static void main(String[]args){

   WebDriver driver = WebDriverFactory.getDriver("chrome");

   driver.get("https://www.tempmailaddress.com/");
   String email = "tayvon.gian@zoofood.org";
   driver.navigate().to("https://practice-cybertekschool.herokuapp.com");

      //  WebDriver driver2 = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Sign Up For Mailing List']")).click();
        driver.findElement(By.name("full_name")).sendKeys("Lea Brown");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();

        String msg = driver.findElement(By.xpath("//h1[.= 'Internal Server Error']")).getText();
        String expectedMsg = "Thank you for signing up. Click the button below to return to the home page.";

        Assert.assertTrue(!msg.equals(expectedMsg),"verify msg is NOT 'Thank you for signing up. Click the button below to return to the home page.'");

        driver.navigate().to("https://www.tempmailaddress.com/");
    }
}
