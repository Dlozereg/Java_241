package org.knit.lab10;

public class Task18 {
    public static void execute(){
        Pair<Integer, Double> pair1 = new Pair<>(2, 4.5);
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        pair1.setFirst(3);
        System.out.println(pair1.getFirst());
    }
}
