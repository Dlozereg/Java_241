package org.knit.lab11;

import org.knit.lab7.Task12;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLException;
import java.util.List;

public class FileProcessor {
    static FileDAO fileDAO;

    public FileProcessor() {
        fileDAO = new FileDAO();
    }

    public int processFiles(String path){
        try {
            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor());
            return 0;
        } catch (IOException e) {
            System.out.println("Ошибка при обходе дерева файлов: " + e.getMessage());
            return 1;
        }
    }

    private static class SimpleFileVisitor implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (Files.size(file) < 1024 * 1024){
                try {
                    FileProcessor.fileDAO.saveFile(file.toFile());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println("Ошибка доступа к файлу: " + file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            return FileVisitResult.CONTINUE;
        }
    }
}
