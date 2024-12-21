package org.knit.lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Number> {
    private List<T> items = new ArrayList<>();

    public void add(T value){
        items.add(value);
    }
    public double sum(){
        double summa = 0;
        for (T item : items){
            summa += item.doubleValue();
        }
        return summa;
    }
}
