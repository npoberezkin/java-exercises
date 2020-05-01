package patterns.behavioral.memento;

public class TextWindow {

    private StringBuilder text = new StringBuilder();

    public StringBuilder getText() {
        return text;
    }

    public void addText(String addedText) {
        text.append(addedText);
    }

    public TextWindowState save() {
        return new TextWindowState(text.toString());
    }

    public void restore(TextWindowState state) {
        this.text = new StringBuilder(state.getText());
    }
}
