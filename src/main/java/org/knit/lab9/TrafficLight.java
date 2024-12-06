package org.knit.lab9;

enum TrafficLight {
    GREEN("YELLOW"),
    YELLOW("RED"),
    RED("GREEN");

    private final String nextLight;

    TrafficLight(String nextLight) {
        this.nextLight = nextLight;
    }

    public String getNextLight() {
        return nextLight;
    }
}
