package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AllCalendarEvents extends BasePage{

    @FindBy(css = ".btn-group.actions-group")
    public WebElement option;
    @FindBy(xpath = "//*[@type='number'][@value='1']")
    public WebElement pageNumber;
    @FindBy(xpath = "//a[@data-size='25']")
    public WebElement ViewPerPage;
    @FindBy(css = ".fa-chevron-right.hide-text")
    public WebElement nextPageArrow;
    @FindBy(css = "table[class*='table']>tbody>tr~tr")
    public WebElement row;
    @FindBy(xpath = "//*[starts-with(text(),'of')]")
    public WebElement numberOfPages;
    @FindBy(xpath = "//*[starts-with(text(),'Total of')]")
    public WebElement TotalOfRecord;
    @FindBy(css = ".visible-items-counter.pagination-centered")
    public WebElement counterRecord;
    @FindBy(xpath = "//*[@data-column-label='Recurrent']")
    public WebElement recurrentCell;
    @FindBy(xpath = "//*[@data-column-label='Recurrence']")
    public WebElement recurrenceCell;
    @FindBy(xpath = "//tr[1]/td[2]")
    public WebElement lastCellInfoIndex;
    @FindBy(css = "[class=\"btn btn-default btn-small dropdown-toggle\"] [type=\"checkbox\"]")
    public WebElement mainCheckBox;
    @FindBy(css = ".grid-row.row-click-action")
    public WebElement checkBoNonSelected;
    @FindBy(css = ".grid-row.row-click-action.row-selected")
    public WebElement checkBoxSelected;

    @FindBy (xpath = "//tr/td[2]")
    public WebElement everyCell;
    String totalNumOfPages = numberOfPages.getText();

    public Integer getLastNumberPage() {
        String num = numberOfPages.getText();
        num = num.replace("Of ", "");
        num = num.replace(" |", "");
        Integer lastPage = Integer.valueOf(num);

        return lastPage;
    }

    public String getLastNumberOfPageString() {
        String num = numberOfPages.getText();
        num = num.replace("Of ", "");
        num = num.replace(" |", "");
        return num;
    }

    public String getAllRecordsString() {
        String numRecords = TotalOfRecord.getText();
        numRecords = numRecords.replace("Total Of ", "");
        numRecords = numRecords.replace(" Records", "");
        return numRecords;
    }

    public Integer getTotalRecords() {
        Integer numRecordsInt = Integer.valueOf(getAllRecordsString());
        return numRecordsInt;
    }

    public String getContainsRecordsString() {
        String counter = counterRecord.getText();
        counter = counter.replace("Showing ", "");
        counter = counter.replace(" of " + getAllRecordsString() + " records", "");
        return counter;
    }

    public Integer getAllContainsRecords() throws InterruptedException {
        Integer containsRecordsInt = Integer.valueOf(getContainsRecordsString());
        return containsRecordsInt;
    }

    public void lastPageRows() throws InterruptedException {

        pageNumber.click();
        pageNumber.clear();
        Thread.sleep(3000);
        pageNumber.sendKeys(getLastNumberOfPageString());
        nextPageArrow.click();
        //  System.out.println(getAllContainsRecords());

        List<WebElement> lastPageRows = Driver.get().findElements(By.cssSelector("td[class*='select-row-cell']"));

        for (WebElement lastPageRow : lastPageRows) {
            if (recurrentCell.getText() != "Yes") {
                System.out.println(lastPageRows);

            }
        }
        Thread.sleep(3000);
        System.out.println("Size of rows in last page: " + lastPageRows.size());

    }

    public void getAllRowsNumber() {
        // List<WebElement> allRowsNumber = Driver.get().findElements(By.cssSelector("table[class*='table']>tbody>tr"));
        List<WebElement> allRowsNumber = Driver.get().findElements(By.cssSelector("tr.grid-row"));
        for (WebElement row : allRowsNumber) {
        }
       //return
        for (WebElement row : allRowsNumber) { }
      // return allRowsNumber.size();
    }
    private int numberColunm;
    private int numberRow;
    public WebElement getCell(int numberColumn, int numberRow) {
        this.numberColunm = numberColumn;
        this.numberRow = numberRow;
        WebElement cell = Driver.get().findElement(By.xpath("//tr["+numberRow+"]/td["+numberColumn+"]"));
        return cell;

    }

    public boolean allCheckBoxesSelected() {
        boolean flag = false;

      List<WebElement> options = Driver.get().findElements(By.cssSelector(".grid-row.row-click-action"));
        WebElement selected = checkBoxSelected;
        for (WebElement element : options) {
            if (element.getAttribute("class").equals("grid-row row-click-action")) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }
}
