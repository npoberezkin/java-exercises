package patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    String name;
    List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public Component add(Component component) {
        components.add(component);
        return component;
    }

    @Override
    public void traverse() {
        System.out.println(name);
        for (Component component : components) {
            System.out.print(name + "--");
            component.traverse();
        }
    }
}
