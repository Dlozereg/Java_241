package org.knit.lab4;

import java.util.Arrays;
import java.util.Random;

public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int palindrome; // Количество слов полиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; //частота букв в словаре (в кадой ячейке хранит частоту букв, а индрес - это позиция буквы в alpabet)
    private Random random;

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;

        dictionarySize = words.length;
        palindrome = findPalindromes();
        maxWordLength = findMaxWordLength();
        minWordLength = findMinWordLength();
        computeFrequency();
        random = new Random();
    }

    // получить случайное слово из словаря
    public String getRandomWord() {
        return words[random.nextInt(dictionarySize)];
    }

    public void printSymbolsStat() {
        for (int i = 0; i < alphabet.length; i++){
            System.out.printf("%s - %d%n", alphabet[i], frequency[i]);
        }
    }

    private int findPalindromes(){
        int count = 0;
        for (String word : words){
            if (word.length() == 1){
                count++;
            }
            else if (word.length() % 2 == 0){
                if (word.substring(0, word.length() / 2).equals(word.substring(word.length() / 2))) {
                    count++;
                }
            }
            else if (word.substring(0, (word.length() + 1) / 2).equals(word.substring((word.length() + 3) / 2))) {
                count++;
            }
        }
        return count;
    }

    private int findMaxWordLength(){
        int max = 0;
        for (String word : words){
            if (word.length() > max){
                max = word.length();
            }
        }
        return max;
    }

    private int findMinWordLength(){
        int min = words[0].length();
        for (String word : words){
            if (word.length() < min){
                min = word.length();
            }
        }
        return min;
    }

    private void computeFrequency(){
        frequency = new int[alphabet.length];
        int count;
        for (String word : words){
            for (int i = 0; i < word.length(); i++){
                for (int j = 0; j < alphabet.length; j++){
                    if (word.charAt(i) == alphabet[j]){
                        frequency[j]++;
                    }
                }
            }
        }
    }

    public int getDictionarySize() {
        return dictionarySize;
    }

    public int getPalindrome() {
        return palindrome;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }
}
