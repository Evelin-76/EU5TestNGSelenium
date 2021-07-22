package com.cybertek.tests.day_13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {


    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

        //I can create String as well as variable and write var name for get(the locator here)
//        loginPage.usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
//        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
//        loginPage.loginButton.click();

        //NOW WE SUBSTITUTED AVOVE FOR METHOD CREATED IN LoginPage TO ACCESS LOCATORS
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
    @Test
    public void loginAsStoreManager(){
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();//here inside the void method createn in LoginPage I implemented all nece
        //ssary implementation for login as StoreManager.It is enough then to call the method only

       Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
}
