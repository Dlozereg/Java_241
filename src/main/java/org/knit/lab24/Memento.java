package org.knit.lab24;

public class Memento {
    private String savedText;

    public Memento(String text) {
        savedText = text;
    }

    public String getSavedText() {
        return savedText;
    }
}
