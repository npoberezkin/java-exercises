package patterns.structural.bridge;

/**
 * Bridge
 */
public abstract class Shape {

    Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public String draw();
}
