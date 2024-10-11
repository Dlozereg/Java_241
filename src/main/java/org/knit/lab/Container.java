package org.knit.lab;

import java.util.Arrays;

public class Container {
    private double volume;
    private final Object[] shapes;
    private int shapesCount = 0;

    public Container(double volume) {
        this.volume = volume;
        shapes = new Object[(int)volume + 1];
    }

    public void add(Shape shape){
        double shapeVolume = shape.getVolume();
        if (volume >= shapeVolume){
            volume -= shapeVolume;
            shapes[shapesCount] = shape;
            shapesCount += 1;
        }
        else throw new ArrayStoreException("Not enough space in Container!");
    }
    public double getVolume(){
        return volume;
    }
    public String getShapes(){
        return Arrays.toString(Arrays.copyOfRange(shapes,0, shapesCount));
    }
}
