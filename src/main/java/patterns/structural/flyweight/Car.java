package patterns.structural.flyweight;

public class Car implements Vehicle {

    Color color;

    public Car(Color color) {
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
