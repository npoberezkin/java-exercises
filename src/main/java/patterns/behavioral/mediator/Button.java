package patterns.behavioral.mediator;

public class Button {

    Mediator mediator;
    boolean isPressed;

    public Button() {
        isPressed = false;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void press() {
        System.out.println("button pressed..");
        isPressed = !isPressed;
        mediator.press();
    }
}
