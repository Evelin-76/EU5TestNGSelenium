package com.cybertek.tests.day_13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    /*
    VERIFY RADIO BUTTONS
        open browser
        login as driver
        go to Activities/Calendar Events
        click on create calendar events
        click on repeat
        verify that repeat every days is checked
        verify that repeat weekday is not checked
     */
    @Test
    public void test1() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage navigate = new DashboardPage();
        //go to Activities/Calendar Events
        navigate.navigateToModule("Activities", "Calendar Events");

        //create an object from this class for work on this page opened
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //method for wait the page to be loaded so we can click on button
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        //through the object we call the method from CreateCalendarEventPage that extends BasePage
       calendarEventsPage.createCalendarEvent.click();

       //create a new object from this class so we can use the method inside it for manage our page
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        //verify checkboxes are selected or not
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify repeat is selected");
        Assert.assertTrue(!createCalendarEventsPage.weekday.isSelected(),"verify" +
                " All-day week is not selected");
    }
    /*
    VERIFY RADIO BUTTONS
        open browser
        login as driver
        go to Activities/Calendar Events
        click on create calendar events
        click on repeat
        verify
     */
   @Test
    public void test2(){
       LoginPage loginPage = new LoginPage();

       loginPage.loginAsDriver();

       DashboardPage navigate = new DashboardPage();
       //go to Activities/Calendar Events
       navigate.navigateToModule("Activities", "Calendar Events");

       //create an object from this class for work on this page opened
       CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

       //method for wait the page to be loaded so we can click on button
       calendarEventsPage.waitUntilLoaderScreenDisappear();
       //through the object we call the method from CreateCalendarEventPage that extends BasePage
       calendarEventsPage.createCalendarEvent.click();

       //create a new object from this class so we can use the method inside it for manage our page
       CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
       createCalendarEventsPage.repeat.click();

       //creating a object where locator of the list by select locator and using Select class
       Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();

       //verify that repeat options are Daily, Weekly, Monthly, Yearly (in this order)
       List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

       //creating a new empty String list for store the WebElements of ArrayList in page and
       //compare them with expected list
       List<String> actualList = new ArrayList<>();

       //creating a list or elements that contains in web
       List<WebElement> actualOptions = repeatsDropdown.getOptions();

       for (WebElement option : actualOptions) {
           //get text of each element and add to actual List
           actualList.add(option.getText());
       }
       Assert.assertEquals(actualList,expectedList,"verify Daily, Weekly, Monthly, Yearly appear and in this order");
   }
}
