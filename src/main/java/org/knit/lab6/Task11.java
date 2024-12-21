package org.knit.lab6;

import java.util.Scanner;
import java.util.TreeSet;

public class Task11 {
    public static void execute(){

        TreeSet<String> students = new TreeSet<>();

        System.out.print("""
                Меню:
                1. Добавить студента
                2. Удалить студента
                3. Показать всех студентов
                4. Найти студента
                5. Выйти""");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        while (cont){
            System.out.print("Введите цифру желаемого действия: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.print("Введите имя студента: ");
                    String name = scanner.nextLine();
                    if (students.contains(name)){
                        System.out.println("Студент уже есть в списке.");
                    }
                    else {
                        students.add(name);
                        System.out.println("Студент добавлен.");
                    }
                }
                case "2" -> {
                    System.out.print("Введите имя студента: ");
                    String name = scanner.nextLine();
                    if (students.contains(name)){
                        students.remove(name);
                        System.out.println("Студент удалён.");
                    }
                    else {
                        System.out.println("Студента нет в списке.");
                    }
                }
                case "3" -> {
                    for (String student : students){
                        System.out.println(student);
                    }
                }
                case "4" -> {
                    System.out.print("Введите имя студента: ");
                    String name = scanner.nextLine();
                    if (students.contains(name)){
                        System.out.println("Студент найден");
                    }
                    else {
                        System.out.println("Студент ещё нет в списке.");
                    }
                }
                case "5" -> {
                    System.out.println("Выход...");
                    cont = false;
                }
                case null, default -> {
                    System.out.println("Некорректный запрос. Пожалуйства, введите цифру из меню.");
                }
            }
        }
    }
}
