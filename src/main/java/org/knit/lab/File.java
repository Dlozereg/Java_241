package org.knit.lab;


public class File extends FileSystemComponent{

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void display(String indent) {
        System.out.printf("%s%s (%d bytes)%n", indent, name, size);
    }
}
