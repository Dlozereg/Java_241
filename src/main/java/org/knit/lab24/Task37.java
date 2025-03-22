package org.knit.lab24;

public class Task37 {
    public static void execute() {
        TextEditor textEditor = new TextEditor();
        Caretaker caretaker = new Caretaker(textEditor);

        textEditor.write("Hello");
        textEditor.show();
        caretaker.saveState();

        textEditor.write(" world");
        textEditor.show();

        caretaker.undo();
        textEditor.show();
    }
}
