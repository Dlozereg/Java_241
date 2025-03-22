package org.knit.lab22;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Task34 {
    public static void execute() {
        BlockingQueue<Detail> stampingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> assembleQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> warehouseQueue = new LinkedBlockingQueue<>();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Stamper(stampingQueue));
        executor.submit(new Assembler(stampingQueue, assembleQueue));
        executor.submit(new Operator(assembleQueue, warehouseQueue));
        executor.shutdown();
    }
}
