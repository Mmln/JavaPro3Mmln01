package org.javapro3;

import org.javapro3.entities.MyClassA;

import static org.javapro3.entities.TestRunner.runTests;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        System.out.println("JavaPro3Mmln01 started...");

        System.out.println("\nTest simplest occurency....");
        MyClassA myClassA = new MyClassA(4,2);
        Class<MyClassA> clA = MyClassA.class;
        runTests(clA);

        //System.out.println("clA=" + clA.toString());

        System.out.println("\nJavaPro3Mmln01 finished...");
    }
}