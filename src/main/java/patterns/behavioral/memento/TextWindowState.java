package patterns.behavioral.memento;

public class TextWindowState {

    private String text;

    public String getText() {
        return text;
    }

    public TextWindowState(String text) {
        this.text = text;
    }
}
