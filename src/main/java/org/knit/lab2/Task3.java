package org.knit.lab2;

import java.util.Scanner;

public class Task3 {

    public static void execute() {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String s;
        double a;
        double b;
        String  operator;

        while (true) {
            System.out.print("Введите первое число: ");
            s = scanner.nextLine();
            if (s.equals("exit")) {
                System.out.println("Выход из программы.");
                break;
            }
            try {
                a = Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Число введено некорректно!");
                continue;
            }

            System.out.print("Введите оператор (+, -, *, /): ");
            operator = scanner.nextLine();
            if (operator.equals("exit")){
                System.out.println("Выход из программы.");
                break;
            }
            if (!((operator.length() == 1) && ("+-*/").contains(operator))) {
                System.out.println("Оператор введён некорректно!");
                continue;
            }

            System.out.print("Введите второе число: ");
            s = scanner.nextLine();
            if (s.equals("exit")){
                System.out.println("Выход из программы.");
                break;
            }
            try {
                b = Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Число введено некорректно!");
                continue;
            }

            switch (operator) {
                case "+" -> System.out.printf("Результат: %s%n", calculator.add(a, b));
                case "-" -> System.out.printf("Результат: %s%n", calculator.substract(a, b));
                case "*" -> System.out.printf("Результат: %s%n", calculator.multiply(a, b));
                case "/" -> {
                    if (b == 0) {
                        System.out.println("Ошибка: Деление на ноль невозможно.");
                    } else System.out.printf("Результат: %s%n", calculator.divide(a, b));
                }
            }
        }
    }
}
