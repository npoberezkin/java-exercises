package patterns.behavioral.mediator;

public class Main {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        Button button = new Button();
        button.setMediator(mediator);
        PowerSupplier powerSupplier = new PowerSupplier();
        powerSupplier.setMediator(mediator);
        Fan fan = new Fan();

        mediator.setButton(button);
        mediator.setFan(fan);
        mediator.setPowerSupplier(powerSupplier);

        powerSupplier.turnOn();
        button.press();
        powerSupplier.turnOff();
        powerSupplier.turnOn();
        button.press();
    }
}
