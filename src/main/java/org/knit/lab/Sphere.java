package org.knit.lab;

public class Sphere extends Shape{
    private double r;

    public Sphere(double r) {
        if (r <= 0) {
            throw new NumberFormatException("Exception: radius must be positive number!");
        }
        this.r = r;
        volume = (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }

    public double getVolume(){
        return volume;
    }
}
