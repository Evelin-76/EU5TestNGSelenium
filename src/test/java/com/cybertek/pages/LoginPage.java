package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {//WE CREATE HERE THE WAIT TO MANAGE, UPDATE AND MAINTAINED
    // OUR LOCATORS IF NECESSARY

    public LoginPage(){

        PageFactory.initElements(Driver.get(),this);
    }

    //use driver.findElement(By.locaterType("locator")
    // i.e. ->driver.findElemnt(By.id("prependedInput")

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;
    @FindBy(id = "_submit")
    public WebElement loginButton;

}
