package com.cybertek.tests.day_13_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Got to Activities / Calendar Events
     * Verify that page subtitle is Calendar Events
     */
    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        //creating an object for get the needed method from abstract class to get text of subtitle
        DashboardPage subtitle = new DashboardPage();
        String actualSubtitle = subtitle.getPageSubTitle();

        Assert.assertEquals(actualSubtitle, expectedSubtitle,"Verify Subtitle is Quick Launchpad ");

        subtitle.navigateToModule("Activities", "Calendar Events");

        //we use the class created for this module that extend BasePage and initialize
        //PageFactory of Selenium to get the url through Driver class pointing 'this'page
        CalendarEventsPage subtitleActivitiesModule = new CalendarEventsPage();

//        BrowserUtils.waitFor(2);->if it fails because we need more time to load the page
        //we can use from this class the method to wait for the necessary time to load page
        //Assert msg will tell us if it fail for this reason. This time is not needed

        Assert.assertEquals(subtitleActivitiesModule.getPageSubTitle(), "Calendar Events",
                "verify subtitle is Calendar Events");
    }
}
