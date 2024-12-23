package org.knit.lab11;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task24 {
    public static void execute() throws SQLException {

        UserService service = new UserService();
        List<String> commands = new ArrayList<>(5);
        Scanner scanner = new Scanner(System.in);
        boolean doContinue = true;
        while (doContinue) {
            Collections.addAll(commands, scanner.nextLine().split(" "));
            switch (commands.getFirst()){
                case "add" -> {
                    if (commands.size() == 4) {
                        service.registerUser(String.join(" ", commands.get(1), commands.get(2)), commands.get(3));
                    }
                    else {
                        System.out.println("Некорректный синтаксис! Шаблон: add [first_name second_name] [email]");
                    }
                }
                case "list" -> {
                    if (commands.size() == 1){
                        List<User> users = service.listAllUsers();
                        for (User user: users){
                            System.out.println("id: " + user.getId() +
                                    ", name: " + user.getName() +
                                    ", email: " + user.getEmail());
                        }
                    }
                    else {
                        System.out.println("Некорректный синтаксис! Команда list печатается без дополнительных слов");
                    }
                }
                case "delete" -> {
                    if (commands.size() == 2) {
                        if (isInteger(commands.get(1), 10)){
                            service.deleteUser(Integer.parseInt(commands.get(1)));
                        }
                        else {
                            System.out.println("Некорректный синтаксис! id должен быть целым числом");
                        }
                    }
                    else {
                        System.out.println("Неккоректный синтаксис! Шаблон: delete [id]");
                    }
                }
                case "update" -> {
                    if (commands.size() == 5){
                        if (isInteger(commands.get(1), 10)){
                            service.updateUser(Integer.parseInt(commands.get(1)),
                                    String.join(" ", commands.get(2), commands.get(3)), commands.get(4));
                        }
                        else {
                            System.out.println("Неккоректный синтаксис! Шаблон: delete [id]");
                        }
                    }
                    else {
                        System.out.println("Некорректный синтаксис! Шаблон: update [id] [new_first_name new_last_name] [new_email]");
                    }
                }
                case "exit" -> {
                    if (commands.size() == 1){
                        System.out.println("Выход...");
                        doContinue = false;
                    }
                    else {
                        System.out.println("Некорректный синтаксис! Команда exit должна писаться без дополнительных слов");
                    }
                }
            }
            commands.clear();
        }
    }

    public static boolean isInteger(String s, int radix) {
        Scanner sc = new Scanner(s);
        if(!sc.hasNextInt(radix)) return false;
        // we know it starts with a valid int, now make sure
        // there's nothing left!
        sc.nextInt(radix);
        return !sc.hasNext();
    }
}
