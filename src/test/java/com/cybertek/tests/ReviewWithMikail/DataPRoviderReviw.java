package com.cybertek.tests.ReviewWithMikail;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DataPRoviderReviw {

    @DataProvider
    public Object[][] capitals() {

        String capitals[][] = {
            {"USA","Washington"},
            {"France","Paris"},
            {"Turkey", "Ankara"},
            {"England","London"},
            {"Spain","Madrid"}};
        return capitals;
    }
    @Test(dataProvider = "capitals")
    public void capitalTest(String country, String capital){
        System.out.println("Capital of " + country + " is: " + capital);
    }

    @DataProvider
    public Object[][] users() {

        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA1-short");
        String data[][] = excelUtil.getDataArrayWithoutFirstRow();

        return data;
    }
    @Test(dataProvider = "users")
    public void usersTest(String username, String password,String firsname, String lastname,String result){

        System.out.println("Username: " + username + " password: " +password + " firstname: "
        + firsname + " lastname: " + lastname + " result: " +result);
    }
    @DataProvider
    public Object [][] calculate(){

        Integer [][] calculo={
                {2,3},
                {10,20},
                {100,200}};

        return calculo;
    }
    @Test(dataProvider = "calculate")
    public void calculate(Integer num1, Integer num2){

        System.out.println("When you multiply " + num1 + " by " + num2 + ", it is equal to "
        + num1*num2);
    }
    @DataProvider
    public Object [][] mix(){

        Object [][] mixing={
                {"Tom",15},
                {"Marcos",20},
                {"Tim",21}};

        return mixing;
    }
    @Test(dataProvider = "mix")
    public void mix(String name, Integer age){

        System.out.println("Name: " + name + ", Age: " + age );
    }
}

