package com.cybertek.tests.day_12_properties_driver_tests;

public class Singleton {

    //singleton class will have private constructor
    //it means other classes cannot create objects of this class
    private Singleton(){}

    private static String str;

    public static String getInstance(){
        //if str has no value, initialize it and return it
        if(str == null){
            System.out.println("str is null. Assigning value to it");
            str= "some value";
        }else{
            //now in the first if stat. we assigned a value so this else stat. will be
            //executed as well
            System.out.println("It has value, just return it");

        }
        return str;
    }
}
