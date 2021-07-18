package com.cybertek.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AcceptCookies {
    WebElement driver;
    public void acceptCookies() throws InterruptedException {
        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies= driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        //Thread.sleep(2000);
        if(acceptAndClose.size() > 0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()> 0){
            acceptCookies.get(0).click();
        }
    }
}
