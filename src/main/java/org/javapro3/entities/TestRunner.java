package org.javapro3.entities;

import org.javapro3.annotations.AfterSuite;
import org.javapro3.annotations.BeforeSuite;
import org.javapro3.annotations.CsvSource;
import org.javapro3.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class TestRunner {

    public static void runTests(Class c) throws IllegalAccessException, IllegalArgumentException, java.lang.reflect.InvocationTargetException{
        Map<Method,Annotation> entities = new HashMap<>();
        Map<Integer,Method> execute = new HashMap<>();
        Map<Integer,Method> sortedExecute = new TreeMap<>(Comparator.reverseOrder());

        Method[] mets = c.getMethods();
        for (Method mt : mets){
            //System.out.println("mt=" + mt + " isStatic=" + Modifier.isStatic(mt.getModifiers()));
            Annotation[] annotations = mt.getAnnotations();
            int beforeSuite = 0;
            int afterSuite = 0;
            for (Annotation an : annotations) {
                //System.out.println("mt,an=" + mt + "::" + an);
                if(mt.isAnnotationPresent(BeforeSuite.class)) {
                    beforeSuite += 1;
                    if(!Modifier.isStatic(mt.getModifiers())) throw new RuntimeException("metod=mt " + " не статический для аннотации @BeforeSuite");
                    if(beforeSuite > 1) throw new RuntimeException("metod=mt " + " annotation @BeforeSuite повторяется больше одного раза.");
                }
                if(mt.isAnnotationPresent(AfterSuite.class)) {
                    afterSuite += 1;
                    if(!Modifier.isStatic(mt.getModifiers())) throw new RuntimeException("metod=mt " + " не статический для аннотации @AfterSuite");
                    if(afterSuite > 1) throw new RuntimeException("metod=mt " + " annotation @AfterSuite повторяется больше одного раза.");
                }
                if(mt.isAnnotationPresent(Test.class)) {
                    Annotation anno = mt.getAnnotation(Test.class);
                    //mt.invoke(c);
                    execute.put(((Test) anno).priority(), mt);
                }
                if(mt.isAnnotationPresent(CsvSource.class)) entities.put(mt ,an);
            }
        }


        sortedExecute.putAll(execute);
        for (Map.Entry<Integer,Method> entry : sortedExecute.entrySet())
        {
            System.out.println(" Key=" + entry.getKey()  + ", Value=" + entry.getValue());
            //Method mtt = entry.    .getValue();

            //mtt.invoke(c.);
        }
        //System.out.println(" ent= " + entities);
        for (Map.Entry<Method,Annotation> entry : entities.entrySet())
        {
            System.out.println("     Key=" + entry.getKey()  + ", Value=" + entry.getValue());
        }



    }


}
