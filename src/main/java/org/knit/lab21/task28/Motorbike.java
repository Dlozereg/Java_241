package org.knit.lab21.task28;

import java.util.HashMap;

public class Motorbike implements Transport {
    static final String deliverySpeed = "fast";

    @Override
    public HashMap<String, String> getSpecifications() {
        HashMap<String, String> specification = new HashMap<>();
        specification.put("deliverySpeed", deliverySpeed);
        return specification;
    }
}
