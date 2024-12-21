package org.knit.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task10 {
    public static void execute() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("misc/dictionary.txt"));
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            if (word.length() > 3){
                words.add(word);
            }
        }
        scanner.close();

        Random random = new Random();
        char[] chosenWord = words.get(random.nextInt(words.size())).toCharArray();
        HashSet<Character> letters = new HashSet<>();
        List<Character> progress = new ArrayList<>();
        for (char ch : chosenWord){
            letters.add(ch);
            progress.add('_');
        }
        HashSet<Character> guessed = new HashSet<>();
        int totalAttempts = 6;
        Scanner scanner1 = new Scanner(System.in);
        while (true){
            System.out.print("Загаданное слово: ");
            for (char ch : progress){
                System.out.print(ch + " ");
            }
            System.out.println();
            System.out.print("Введите букву: ");
            String guess = scanner1.nextLine();
            if (guess.length() > 1){
                System.out.println("Необходимо ввести одну букву!");
                continue;
            }
            if (guessed.contains(guess.charAt(0))){
                System.out.println("Эта буква уже была!");
                continue;
            }
            if (letters.contains(guess.charAt(0))){
                for (int i = 0; i < chosenWord.length; i++){
                    if (chosenWord[i] == guess.charAt(0)){
                        progress.set(i, chosenWord[i]);
                    }
                }
                guessed.add(guess.charAt(0));
                letters.remove(guess.charAt(0));
                if (letters.isEmpty()) {
                    System.out.println("Слово было полностью отгадано!");
                    break;
                }
            }
            else {
                guessed.add(guess.charAt(0));
                totalAttempts -= 1;
                if (totalAttempts == 0){
                    System.out.println("Game over!");
                    break;
                }
                System.out.println("Неверно! Осталось попыток: " + totalAttempts);
            }
        }
    }
}
