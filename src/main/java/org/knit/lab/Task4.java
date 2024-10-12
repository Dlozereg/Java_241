package org.knit.lab;

public class Task4 {
    public void execute() {
        Container container = new Container(1000);

        Shape sphere = new Sphere(5);
        Shape cube = new Cube(3);
        Shape cylinder = new Cylinder(100, 100);

        container.add(sphere);
        container.add(cube);

        System.out.println(container.getVolume());
        System.out.println(container.getShapes());

        try{
            container.add(cylinder);
        }
        catch (ArrayStoreException e){
            System.out.println(e);
        }

        try {
            Shape impossible = new Cube(0);
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }
    }
}
