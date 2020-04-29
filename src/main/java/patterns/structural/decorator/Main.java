package patterns.structural.decorator;

public class Main {

    /**
     * Real world example: File streams
     * @param args
     */
    public static void main(String[] args) {
        Widget widget = new BorderDecorator(new BorderDecorator(new ScrollDecorator(new TextField("text"))));
        widget.draw();
    }
}
