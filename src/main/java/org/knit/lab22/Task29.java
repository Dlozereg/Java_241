package org.knit.lab22;

public class Task29 {
    // 2.4 Задача «Автозаправочная станция» 🚗⛽
    public static void execute() {
        for (int i = 1; i <= 10; i++){
            new Thread(() -> GasStation.Refuel(Thread.currentThread().getName()), "Машина " + i).start();
        }
    }
}
