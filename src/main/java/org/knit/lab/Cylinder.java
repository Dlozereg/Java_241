package org.knit.lab;

public class Cylinder extends Shape{
    private double h;
    private double r;

    public Cylinder(double h, double r) {
        if (h <= 0) {
            throw new NumberFormatException("Exception: height must be positive number!");
        } else if (r <= 0) {
            throw new NumberFormatException("Exception: radius must be positive number!");
        }
        this.h = h;
        this.r = r;
        volume = Math.PI * Math.pow(r, 2) * h;
    }

    public double getVolume(){
        return volume;
    }
}
