package org.knit.lab2;

public class Folder extends FileSystemComponent{
    Object[] insides;
    int insidesCount = 0;

    public Folder(String name) {
        this.name = name;
        insides = new Object[1000];
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void add(FileSystemComponent component){
        insides[insidesCount] = component;
        size += component.getSize();
        insidesCount += 1;
    }

    public void remove(FileSystemComponent component){
        if (insidesCount == 0){
            throw new ArrayStoreException("No components to remove!");
        }
        else{
            insides[insidesCount] = null;
            insidesCount -= 1;
        }
    }

    public void display(String indent) {
        System.out.printf("%s%s (%d bytes)%n", indent, name, size);
        for (int i = 0; i < insidesCount; i++){
            if (insides[i] instanceof File){
                ((File) insides[i]).display(indent + "  ");
            }
            else ((Folder) insides[i]).display(indent + "  ");
        }
    }
}
