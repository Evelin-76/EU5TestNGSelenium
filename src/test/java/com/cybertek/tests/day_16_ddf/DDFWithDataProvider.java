package com.cybertek.tests.day_16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object [][] testData(){
        String [][] data = {
                {"A","1"},
                {"B","2"},
                {"C","3"},
                {"D","4"},
                {"E","5"},
        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void test1(String alphabetLetter, String positionNumber){

        System.out.println("Alphabet letter is: " + alphabetLetter + " and its position number " +
                "is: " + positionNumber);
    }
}
