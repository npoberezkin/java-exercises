package patterns.structural.decorator;

public class TextField implements Widget {

    String text;

    public TextField(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        System.out.println(text);
    }
}
