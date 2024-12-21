package org.knit.lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Task12 {
    public static void execute(){

        Path startPath = Paths.get("misc/Directory"); // начальная директория для обхода

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor());
        } catch (IOException e) {
            System.out.println("Ошибка при обходе дерева файлов: " + e.getMessage());
        }
    }

    // Реализация FileVisitor для обхода файловой системы
    private static class SimpleFileVisitor implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            System.out.println("Каталог: " + dir.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("Файл: " + file.toString());
            long wordCount = countWords(file);
            System.out.println("Количество слов: " + wordCount);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println("Ошибка доступа к файлу: " + file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            System.out.println("Завершение каталога: " + dir.toString());
            return FileVisitResult.CONTINUE;
        }
    }

    private static long countWords(Path filePath) throws IOException {
        long wordCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на слова, используя пробелы и другие разделители
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }

        return wordCount;
    }
}
