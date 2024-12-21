package org.knit.lab5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task9 {

    public static void execute() throws FileNotFoundException {
        //получает текущее время в миллисекундах
        List<String> allWords = getWords("misc/dictionary.txt");
        Scanner scanner = new Scanner(System.in);
        int totalGuesses = 0;
        int rightGuesses = 0;
        int totalChars = 0;
        long timeMillis = System.currentTimeMillis() + 60_000;
        while (System.currentTimeMillis() < timeMillis){
            System.out.print("Введите слово: ");
            String guess = scanner.nextLine();
            if (System.currentTimeMillis() < timeMillis) {
                totalChars += guess.length();
                if (allWords.contains(guess)) {
                    System.out.println("Слово угадано верно, +1 минута");
                    timeMillis += 60_000;
                    rightGuesses++;
                } else {
                    System.out.printf("Слово угадано неверно, осталось %d секунд!%n", (timeMillis - System.currentTimeMillis()) / 1000);
                }
                totalGuesses++;
            }
        }
        scanner.close();
        System.out.println("Время вышло");
        System.out.printf("Всего угадываний - %d, верных - %d%nВсего введено символов - %d",
                totalGuesses, rightGuesses, totalChars);
    }

    //Возвращает список слов из файла
    public static List<String> getWords(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();
        return words;
    }
}
