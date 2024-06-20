package org.javapro3.entities;

import org.javapro3.annotations.AfterSuite;
import org.javapro3.annotations.BeforeSuite;
import org.javapro3.annotations.CsvSource;
import org.javapro3.annotations.Test;

public class MyClassA {
    private int a;
    private int b;

    public MyClassA() {
    }

    public MyClassA(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @BeforeSuite
    public static int addition(int pa, int pb){
        return pa + pb;
    }

    @AfterSuite
    public static int difference(int pa, int pb){
        return pa - pb;
    }

    @Test(priority=2)
    public void multiplication2(){
        System.out.println("multiplication2");
    }

    @Test
    public void multiplication5(){
        System.out.println("multiplication5");
    }

    @Test(priority=4)
    public void multiplication4(){
        System.out.println("multiplication4");
    }

    @Test(priority=3)
    public void multiplication3(){
        System.out.println("multiplication3");
    }

    @CsvSource
    public void testMethod(int pa, String pb, int pc, boolean pd){
        System.out.println("pa=" + pa + "pb=" + pb + "pc=" + pc + "pd=" + pd);
    }

}
