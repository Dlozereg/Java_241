package org.knit.lab21.task28;

public class TransportFactory {
    static Transport createTransport(String tripType){
        return switch (tripType) {
            case "business" -> new BusinessCar();
            case "family" -> new FamilyCar();
            case "delivery" -> new Motorbike();
            default -> {
                System.out.println("not a valid trip type");
                yield null;
            }
        };
    }
}
