package patterns.structural.decorator;

public class Main {

    public static void main(String[] args) {
        Widget widget = new BorderDecorator(new BorderDecorator(new ScrollDecorator(new TextField("text"))));
        widget.draw();
    }
}
