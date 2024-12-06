package org.knit.lab2;

public abstract class FileSystemComponent {
    String name;
    int size = 0;
    abstract String getName();
    abstract int getSize();
    abstract void display(String indent);

    void remove(FileSystemComponent component){

    }
    void add(FileSystemComponent component) {
    }
}
