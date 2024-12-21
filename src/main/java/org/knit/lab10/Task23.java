package org.knit.lab10;

import java.lang.reflect.Type;

public class Task23 {
    public static void execute(){
        printType(123); // java.lang.Integer
        printType("Hello"); // java.lang.String
    }

    public static <T> void printType(T obj){
        System.out.println(obj.getClass());
    }
}
