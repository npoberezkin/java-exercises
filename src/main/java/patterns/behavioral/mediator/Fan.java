package patterns.behavioral.mediator;

public class Fan {
    private boolean isOn;

    public Fan() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("fan is on");
    }

    public void turnOff() {
        System.out.println("fan is off");
        isOn = false;
    }
}
