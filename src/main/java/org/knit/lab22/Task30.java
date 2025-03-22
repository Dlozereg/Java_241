package org.knit.lab22;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Task30 {
    // 2.5 Задача «Ресторан: Повар и Официант» 🍽️👨‍🍳
    public static void execute() {
        BlockingQueue<String> dishes = new ArrayBlockingQueue<>(3);

        new Thread(new Cook(dishes)).start();
        new Thread(new Waiter(dishes)).start();
    }
}
