package com.cybertek.tests.ReviewWithMikail;

import com.cybertek.utilities.ExcelUtil;
import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExelReview {

    Faker faker = new Faker();

    //WE CREATED FIRST OF FIRT THE CLASS WITH CONSTRUCTOR USER FOR CREATE THE OBJECT
    //IT MATCH WITH THE COLUMN NAME AND NUMBERS FOR HEAD OF TABLE
    //here we decide our column numbers with the name of them
    static String[] collumns = {"username","password","firstName","lastName"};
    static List<Users> users= new ArrayList<>();

    @Test
    public  void  createExcelFile() throws IOException {

        //assigning the value for every var created
        int count = 1;
        for (int i = 0; i < 5; i++) {
            String username = "User" + count;
            String password = "UserUSer123";
            String firsName = faker.name().firstName();
            String lastName = faker.name().lastName();
            count++;
            users.add((new Users(username,password,firsName,lastName)));

        }

        //for use our data we call Workbook and create an object for call methods
        //it is an interface.Polymorphism for use cast method of XSSFWorkbook class
        Workbook workbook = new XSSFWorkbook();

        //creating an excel sheet using workbook methods and giving name "Users"
        Sheet sheet = workbook.createSheet("Users");
        //designing the sheet
        Font headerFont = workbook.createFont();

        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 15);
        headerFont.setColor((IndexedColors.PINK.getIndex()));


        CellStyle headerCellStyle = workbook.createCellStyle();

        headerCellStyle.setFont(headerFont);

        //creating the row after create sheet:
        //this one is the header == 0
        Row headerRow = sheet.createRow(0);

        for(int i = 0; i < collumns.length; i++){
            //creating cells
            Cell cell = headerRow.createCell(i);
            //giving the name of every header cell
            cell.setCellValue(collumns[i]);
            //here we are changing the value of every cell while we are introducing data
            cell.setCellStyle(headerCellStyle);
        }
        //now we are creating the information for users with data
        //first row for user is number 1
        int rowCount = 1;
        for (Users user : users) {
            //creating rows with data from faker untill the number selectic
            //we decided 5 rows at the beginning of the class
            Row row = sheet.createRow(rowCount++);

            //assigning the column to every user date entered
            row.createCell(0).setCellValue(user.username);
            row.createCell(1).setCellValue(user.password);
            row.createCell(2).setCellValue(user.firsName);
            row.createCell(3).setCellValue(user.lastName);

        }
        //make automatic the creation of  columns
        //here it is selected from the beginning with the number or parameter we applied
        //it is username, password, firstname and lastname
        for (int i = 0; i < collumns.length; i++) {
           sheet.autoSizeColumn(i);
        }
        //here we create the path to send our file and create a folder where store it in
        //our working directory
        FileOutputStream fileoutputStream = new FileOutputStream("Users.xlsx");

        //b4 to close all we write our data an close
        workbook.write(fileoutputStream);
        fileoutputStream.close();
        workbook.close();

        }
@Test
    public void getCell(){
    ExcelUtil excelUtil = new ExcelUtil("Users.xlsx", "Users");
    System.out.println(excelUtil.rowCount());
    System.out.println(excelUtil.getDataArray()[2][2]);//using array
    System.out.println(excelUtil.getCellData(2, 2));//regular string
    System.out.println(excelUtil.getColumnsNames());//columns names
    System.out.println(excelUtil.columnCount());//number of columns
    System.out.println(excelUtil.getDataList().get(0).get("username"));

}
    }

