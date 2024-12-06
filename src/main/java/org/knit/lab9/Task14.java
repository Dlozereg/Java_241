package org.knit.lab9;

import java.util.Scanner;

public class Task14 {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текущий сигнал светофора (GREEN, YELLOW, RED): ");
        TrafficLight currentLight = TrafficLight.valueOf(scanner.next());
        System.out.println("Следующий сигнал: " + currentLight.getNextLight());
    }
}
