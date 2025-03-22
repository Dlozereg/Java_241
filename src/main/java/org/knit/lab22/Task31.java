package org.knit.lab22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task31 {
    // 2.6 Задача «Железнодорожный переезд» 🚆🚗
    public static void execute() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        LevelCrossing levelCrossing = new LevelCrossing();

        executor.submit(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(5000);
                    levelCrossing.TrainRoad();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        executor.submit(() -> {
            for (int i = 1; i <= 13; i++) {
                levelCrossing.CarRoad(Integer.toString(i) + "a");
            }
        });

        executor.submit(() -> {
            for (int i = 1; i <= 15; i++) {
                levelCrossing.CarRoad(Integer.toString(i) + "b");
            }
        });

        executor.shutdown();
    }
}
