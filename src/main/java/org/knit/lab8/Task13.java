package org.knit.lab8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task13 {
    public static void execute() throws IOException, ClassNotFoundException {
        System.out.println("""
                Добро пожаловать в систему управления пользователями!
                Выберите действие:
                1. Добавить нового пользователя
                2. Показать всех пользователей
                3. Сохранить список пользователей в файл
                4. Загрузить список пользователей из файла
                5. Выйти""");

        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        while (cont){
            System.out.print("Введите номер действия: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.print("Введите имя пользователя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите возраст: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите email: ");
                    String email = scanner.nextLine();
                    users.add(new User(name, age, email));
                    System.out.println("Пользователь добавлен.");
                }
                case "2" -> {
                    System.out.println("Список пользователей:");
                    for (int i = 0; i < users.size(); i++){
                        System.out.println(i + ". " + users.get(i));
                    }
                }
                case "3" -> {
                    UserManager.saveUsers(users);
                    System.out.println("Список успешно сохранён в файл.");
                }
                case "4" -> {
                    users.clear();
                    users = UserManager.loadUsers();
                    System.out.println("Список успешно загружен из файла.");
                }
                case "5" -> {
                    UserManager.saveUsers(users);
                    cont = false;
                    System.out.println("Программа завершена.");
                }
                case null, default -> {
                    System.out.println("Некорректный запрос. Пожалуйства, введите цифру из меню.");
                }
            }
        }
    }
}
