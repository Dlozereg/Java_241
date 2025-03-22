package org.knit.lab23;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task35 {
    /* Задача 10: Гонка бегунов с использованием CyclicBarrier 🏃‍♂️🏃‍♀️
    * Группа спортсменов участвует в забеге. Однако перед началом гонки все должны собраться на старте.
    * Как только все участники будут готовы, забег начнётся одновременно. Используйте CyclicBarrier,
    * чтобы синхронизировать запуск гонки.
    * Каждый бегун стартует одновременно, затем бежит разное время (симулируется Thread.sleep),
    * после чего финиширует. Как только все бегуны завершат дистанцию, программа выводит сообщение о
    * завершении гонки.*/

    /*RUNNERSCOUNT бегунов готовяться к старту, после чего начинается забег. На финише все бегуны
    * дожидаются окончания гонки.*/

    static final int RUNNERSCOUNT = 5;

    public static void execute() {

        AtomicBoolean runstarted = new AtomicBoolean(false);
        AtomicBoolean isEveryoneAlive = new AtomicBoolean(true);

        CyclicBarrier barrier = new CyclicBarrier(RUNNERSCOUNT, () -> {
            if (!runstarted.get()) {
                System.out.println("Старт забега");
                runstarted.set(true);
            }
            else {
                System.out.println("Конец забега");
                runstarted.set(false);
            }
        });
        try (ExecutorService executor = Executors.newFixedThreadPool(RUNNERSCOUNT)) {
            for (int i = 1; i <= RUNNERSCOUNT; i++) {
                executor.submit(new Runner(i, barrier, isEveryoneAlive));
            }
            executor.shutdown();
        }

    }
}
