package org.knit.lab22;

import java.util.ArrayList;

public class Task33 {
    public static void execute() {
        Intersection intersection = new Intersection();

        new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                try {
                    intersection.changeTrafficLight("yellow");
                    Thread.sleep(1500);
                    intersection.changeTrafficLight("green");
                    Thread.sleep(3000);
                    intersection.changeTrafficLight("yellow");
                    Thread.sleep(1500);
                    intersection.changeTrafficLight("red");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "TrafficLight").start();

        String[] paths = {"a", "b", "c", "d"};
        for (int i = 0; i < 4; i++) {
            String path = paths[i];
            new Thread(() -> {
                for (int j = 1; j <= 10; j++) {
                    intersection.drive(Integer.toString(j) + path);
                }
            }, "Road " + path).start();
        }
    }
}
