package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BasePage{

    public ContactPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//table//tbody//tr[4]/td[4]")
    public WebElement email;
    @FindBy(xpath = "//*[@class='user-name']")
    public WebElement fullName;
    @FindBy(xpath = "//*[@title='mbrackstone9@example.com']")
    public  WebElement emailMariam;
    @FindBy(xpath = "//*[@title='+18982323434']")
    public WebElement phoneNumber;
}
