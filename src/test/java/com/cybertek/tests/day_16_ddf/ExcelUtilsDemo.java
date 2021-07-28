package com.cybertek.tests.day_16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

    //create an object from ExcelUtil
        //it accepts two arguments
        //Argument 1: location of the file(path)
        //Argument 2: sheet that we want to open(sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx",
                "QA3-short");

        //how many rows we have in the sheet
        System.out.println("How many rows we have: " + qa3short.rowCount());

        //how many columns we have in the sheet
        System.out.println("Columns number: " + qa3short.columnCount());

        //get all columns name
        System.out.println("Get all columns name: " + qa3short.getColumnsNames());

        //get all data in list of maps
        List<Map<String,String>> dataList = qa3short.getDataList();
        int counter = 1;
        for (Map<String,String> onerow :  dataList) {
            System.out.print(counter++ + ". ");
            System.out.println(onerow);
        }

        //get Nona as a value.Key is firstname and value is Nona
        // It is index 3 but starting from 0 = 2
        //directly from the object created
        System.out.println("Get Nona as value: " + qa3short.getDataList().get(2).get("firstname"));
        //another name got from the List dataList created here in iteration
        System.out.println("Getting another value: " + dataList.get(8).get("lastname"));

        //get all data in 2d array
        String[][] dataArray = qa3short.getDataArray();
        //print 2d array
        System.out.println(Arrays.deepToString(dataArray));

    }
}
