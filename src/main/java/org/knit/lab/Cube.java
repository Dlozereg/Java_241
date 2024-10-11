package org.knit.lab;

public class Cube extends Shape{
    private double a;

    public Cube(double a) {
        if (a <= 0) {
            throw new NumberFormatException("Edge must be positive number!");
        }
        this.a = a;
        volume = Math.pow(a, 3);
    }

    public double getVolume(){
        return volume;
    }
}
