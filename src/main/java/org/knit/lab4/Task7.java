package org.knit.lab4;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task7 {
    public static void execute() throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();
        char[] alphabet = "абвгдежзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        Scanner scanner = new Scanner(new File("misc/dictionary.txt"));
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();
        DictionaryStatistic d = new DictionaryStatistic(words.toArray(new String[0]), alphabet);
        System.out.println(d.getRandomWord());
        System.out.println(d.getRandomWord());
        System.out.println(d.getDictionarySize());
        System.out.println(d.getPalindrome());
        System.out.println(d.getMaxWordLength());
        System.out.println(d.getMinWordLength());
        d.printSymbolsStat();
    }
}
