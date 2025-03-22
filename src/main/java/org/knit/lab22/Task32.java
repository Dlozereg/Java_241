package org.knit.lab22;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Task32 {
    public static void execute() {
        BlockingQueue<String> itemStock = new ArrayBlockingQueue<>(5);

        new Thread(new Producer(itemStock)).start();
        new Thread(new Consumer(itemStock)).start();
    }
}
