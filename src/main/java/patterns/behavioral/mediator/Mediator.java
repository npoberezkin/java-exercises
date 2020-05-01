package patterns.behavioral.mediator;

public class Mediator {

    private Button button;
    private Fan fan;
    private PowerSupplier powerSupplier;

    public Mediator() {
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public void setPowerSupplier(PowerSupplier powerSupplier) {
        this.powerSupplier = powerSupplier;
    }

    public void press() {
        if (powerSupplier.isOn()) {
            if (fan.isOn()) {
                fan.turnOff();
            } else {
                fan.turnOn();
            }
        }
    }

    public void powerOn() {
        if (button.isPressed) {
            fan.turnOn();
        }
    }

    public void powerOff() {
        fan.turnOff();
    }
}
