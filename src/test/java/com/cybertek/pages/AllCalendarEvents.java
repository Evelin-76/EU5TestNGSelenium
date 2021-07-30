package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllCalendarEvents extends BasePage{

    @FindBy(css = ".btn-group.actions-group")
    public WebElement option;
    @FindBy(xpath = "//*[@type='number'][@value='1']")
    public WebElement pageNumber;
    @FindBy(xpath = "//a[@data-size='25']")
    public WebElement ViewPerPage;
    @FindBy(css = "table[class*='table']>tbody>tr~tr")
    public WebElement row;
    @FindBy(xpath = "//*[starts-with(text(),'of')]")
    public WebElement numberOfPages;
    @FindBy(xpath = "//*[starts-with(text(),'Total of')]")
    public WebElement TotalOfRecord;
    @FindBy (xpath = "//tr/td[2]")
    public WebElement everyCell;
    String totalNumOfPages = numberOfPages.getText();

    public Integer getLastNumberPage(){
        String num =numberOfPages.getText();
        num = num.replace("Of ","");
        num = num.replace(" |","");

        Integer lastPage = Integer.valueOf(num);

        return lastPage;
    }
    public String getLastNumberOfPage(){
        String num =numberOfPages.getText();
        num = num.replace("Of ","");
        num = num.replace(" |","");
        return num;
    }

    public void lastPageRows() throws InterruptedException {
     pageNumber.click();
     pageNumber.clear();
     pageNumber.sendKeys(getLastNumberOfPage());
        Thread.sleep(5000);
            List<WebElement> lastPageRows = Driver.get().findElements(By.cssSelector("tr.grid-row"));

            for (WebElement lastPageRow : lastPageRows) {
            }
            System.out.println("Size of rows in last page: " + lastPageRows.size());

    }

    public int getAllRowsNumber(){
       // List<WebElement> allRowsNumber = Driver.get().findElements(By.cssSelector("table[class*='table']>tbody>tr"));
        List<WebElement> allRowsNumber = Driver.get().findElements(By.cssSelector("tr.grid-row"));
        for (WebElement row : allRowsNumber) { }
       return allRowsNumber.size();
    }
    private int numberColunm;
    private int numberCell;
    public WebElement getCell(int numberColumn, int numberCell){
        this.numberColunm = numberColumn;
        this.numberCell = numberCell;
        WebElement cell = Driver.get().findElement(By.xpath("//tr["+numberColumn+"]/td["+numberCell+"]"));
        return cell;

    }
}
