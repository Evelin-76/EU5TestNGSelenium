package com.cybertek.tests.day_12_properties_driver_tests;

import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1(){
       // Singleton singelton = new Singleton();-> we cannot create an object due constructor
                //  is private. We need to create an access to it through a method
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
