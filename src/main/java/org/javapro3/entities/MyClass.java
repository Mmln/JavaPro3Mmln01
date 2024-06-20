package org.javapro3.entities;

import org.javapro3.annotations.AfterSuite;
import org.javapro3.annotations.BeforeSuite;
import org.javapro3.annotations.CsvSource;
import org.javapro3.annotations.Test;

public class MyClass {
    private int a;
    private int b;

    public MyClass() {
    }

    public MyClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @BeforeSuite
    public int addition(int pa, int pb){
        return pa + pb;
    }

    @AfterSuite
    public int difference(int pa, int pb){
        return pa - pb;
    }

    @Test
    public int multiplication(int pa, int pb){
        return pa - pb;
    }

    @CsvSource
    public void testMethod(int pa, String pb, int pc, boolean pd){
        System.out.println("pa=" + pa + "pb=" + pb + "pc=" + pc + "pd=" + pd);
    }

}
