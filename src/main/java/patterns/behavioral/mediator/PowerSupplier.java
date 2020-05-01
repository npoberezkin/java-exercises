package patterns.behavioral.mediator;

public class PowerSupplier {

    Mediator mediator;
    private boolean isOn;

    public PowerSupplier() {
        this.isOn = false;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOff() {
        System.out.println("power supply is off");
        isOn = false;
        mediator.powerOff();
    }

    public void turnOn() {
        System.out.println("power supply is on");
        mediator.powerOn();
        isOn = true;
    }

}
