package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Watchable;

public class CalendarEventsGeneralInformation extends BasePage{

    @FindBy(css = ".control-group.attribute-row")
    public WebElement headRow;

}

