package com.cybertek.tests.day_12_properties_driver_test;

public class Singleton {

    //singleton class will have private constructor
    //it means other classes CANNOT create object of this class
    private  Singleton(){}//this is the constructor

    private static String str;//creating string

    public static String getInstance(){//creating a method to call it from Singleton constructor

        //if str has no value, initalize it an return it
        if((str == null)){
            System.out.println("str is null assigning value it");
            str = "Some value assigned here";//assigning here a value
        }else{
            //if it has value just return it
            System.out.println("it has value now so returning this");
        }
        return str;
    }
}
