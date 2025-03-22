package org.knit.lab24;

public class Caretaker {
    private TextEditor textEditor;
    private Memento prevState;

    public Caretaker(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void saveState() {
        prevState = textEditor.saveState();
    }

    public void undo() {
        textEditor.restore(prevState);
    }
}
