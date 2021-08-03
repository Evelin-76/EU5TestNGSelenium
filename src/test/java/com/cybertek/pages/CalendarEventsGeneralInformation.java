package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Watchable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarEventsGeneralInformation extends BasePage{

    @FindBy(css = ".control-group.attribute-row")
    public WebElement headRow;


    public void GeneralInfoTable() throws InterruptedException {
        int counter = 1;
        Integer count = counter;
        int counter1 = 1;
        Integer count1 = counter1;
        List<WebElement> headKey = Driver.get().findElements(By.xpath("//label[@class='control-label']["+count+"]"));
        List<WebElement> values = Driver.get().findElements(By.xpath("//div[starts-with(@class,'control-label')]["+count1+"]"));

        Map<String, String> tableInfo = new HashMap<>();

        System.out.println(count + " " + count1);

            for (WebElement key : headKey) {

                System.out.println(key.getText());



         //   System.out.println(tableInfo);

        }

        for(int i = 1; i < 10; i++) {
          //  System.out.println(i);
            WebElement element = Driver.get().findElement(By.xpath("//div[starts-with(@class,'control-label')][" + i+ "]"));

            Thread.sleep(2000);
            // System.out.println(count + " " + count1);
            System.out.println(element.getText());

            // tableInfo.put(key.getText(), value.getText());

        }




    }

}

