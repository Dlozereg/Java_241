package org.knit.lab11;

import java.util.Scanner;

public class Task25 {
    public static void execute(){

        Scanner scanner = new Scanner(System.in);
        FileProcessor processor = new FileProcessor();
        System.out.print("Введите путь к файлу или папке: ");
        String path = scanner.nextLine();
        if (processor.processFiles(path) == 1) {
            System.out.println("Файлы весом менее 10мб были сохранены в таблицу");
        }
    }
}
