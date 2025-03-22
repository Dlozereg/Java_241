package org.knit.lab21.task28;

public class Task28 {
    public static void execute(){
        Transport businessCar = TransportFactory.createTransport("business");
        System.out.println(businessCar.getSpecifications().toString());
        Transport familyCar = TransportFactory.createTransport("family");
        System.out.println(familyCar.getSpecifications().toString());
        Transport motorbike = TransportFactory.createTransport("delivery");
        System.out.println(motorbike.getSpecifications().toString());
        Transport Car = TransportFactory.createTransport("car");
    }
}
