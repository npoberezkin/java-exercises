package patterns.behavioral.memento;

public class TextEditor {

    private TextWindow window;
    private TextWindowState state;

    public TextEditor(TextWindow window) {
        this.window = window;
    }

    public void addText(String addedText) {
        window.addText(addedText);
    }

    public String getText() {
        return window.getText().toString();
    }

    public void save() {
        System.out.println("saving state..");
        state = window.save();
    }

    public void undo() {
        System.out.println("reverting state..");
        window.restore(state);
    }
}
