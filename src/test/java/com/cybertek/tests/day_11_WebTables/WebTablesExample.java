package com.cybertek.tests.day_11_WebTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void printTable(){

        //getting locator for full table1
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));

        String textTable1 = table1.getText();
        System.out.println(textTable1);//printing as a String all together

        Assert.assertTrue(table1.getText().contains("jdoe@hotmail.com"),"verify if table1 contains 'jdoe@hotmail.com'");
     }
     @Test
    public void getAllHeaders(){

        //how many columns we have in table
         List<WebElement> columnsHeaders = driver.findElements(By.xpath("//table[@id='table1']//th"));

         System.out.println(columnsHeaders.size());

         for (WebElement header : columnsHeaders) {
             System.out.println(header.getText());
         }
     }
     @Test
    public void printTableSize(){
        //how many columns we have
         List<WebElement> rowsHeaders = driver.findElements(By.xpath("//table[@id='table1']//tr"));
         System.out.println(rowsHeaders.size());

         //printing numbers of rows without count header rows
         List<WebElement> rowsBody = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
          System.out.println(rowsBody.size());

     }
     @Test
    public void getRow(){
        //print the second row information
         System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]")).getText());

         //get all rows dynamically
         List<WebElement> allRowsBodyElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

         //with forEach loop
         for (WebElement allRowsBodyElement : allRowsBodyElements) {
             System.out.println(allRowsBodyElement.getText());
         }
         //or with iterator for loop
         for (int i = 1; i <= allRowsBodyElements.size(); i++) {
             WebElement rowsBodyElements = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
             System.out.println(i + "-" + rowsBodyElements.getText());
         }
     }
     @Test
        public void getAllCellInOneRow(){

        //printing only all elements of first row (surnames)
         List<WebElement> allElementsOneCellRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
         for (WebElement row : allElementsOneCellRow) {
             System.out.println(row.getText());
         }
         //printing all elements of every row by lines

     }
     @Test
    public void getAsingleCellByIndex(){

        //looking locator for the element I want to print of the table
         WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[4]"));
         System.out.println(element.getText());
     }
     @Test
    public void printAllCellByIndex(){
         List<WebElement> allCells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
         for (WebElement allCell : allCells) {
             System.out.println(allCell.getText());

         }

         //getting same result through nested for loop
        //1.Create a method(short cut click option on the red text of method name to create method
         int rowNumber = getNumberOfRows();
         int colNumber = getNumberOfColumns();

         System.out.println("Columns number: " + getNumberOfColumns());
         System.out.println("Rows number: " + getNumberOfRows());

         //iterate through each row on the table nesting loops
         for (int i = 1; i <=  rowNumber; i++) {
             //iterate each column
             for (int j = 0; j <= colNumber; j++) {
                 //we create a String to store the code for dynamic locator to use it later
                 String cellXpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[1]";
                 System.out.println(cellXpath);

                 //for print html elements we locate them and we can work with getText method
                 //this case we have it done in a String above
                 WebElement cell = driver.findElement(By.xpath(cellXpath));
                 System.out.println(cell.getText());
             }
         }
     }
     @Test
     public void getCellInRelationToAnotherCellInSameRow(){

        //Static locator
        String xpath = "//table[@id='table1']//td[.='John']/../td[5]";
        WebElement email = driver.findElement(By.xpath(xpath));
         System.out.println(email.getText());

         //Dynamic locator done we changed ->//td[.='John'] avobe for a new name
         String firstName = "James";//now it is not John but James
         String xpathDynamic = "//table[@id='table1']//td[.='" + firstName + "']/../td[5]";
         WebElement emailGet = driver.findElement(By.xpath(xpath));
         System.out.println(emailGet.getText());

     }

    private int getNumberOfColumns() {
        List<WebElement> columnsHeaders = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return columnsHeaders.size();
    }

    private int getNumberOfRows() {
        List<WebElement> allRowsBodyElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsBodyElements.size();
    }


}
