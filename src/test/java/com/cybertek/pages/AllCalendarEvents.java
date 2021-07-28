package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllCalendarEvents extends BasePage{

    @FindBy(css = ".btn-group.actions-group")
    public WebElement option;
    @FindBy(xpath = "//*[@type='number'][@value='1']")
    public WebElement pageNumber;
    @FindBy(xpath = "//a[@data-size='25']")
    public WebElement ViewPerPage;
}
