package patterns.behavioral.memento;

public class Main {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(new TextWindow());
        editor.addText("Hello world!");
        System.out.println(editor.getText());
        editor.save();
        System.out.println(editor.getText());
        editor.addText("Or, no.. Forget it!");
        System.out.println(editor.getText());
        editor.undo();
        System.out.println(editor.getText());
    }
}
