package patterns.structural.composite;

public class Main {

    public static void main(String[] args) {
        Composite container1 = new Composite("container-1");
        Composite container2 = new Composite("container-2");
        container1.add(new Primitive(1));
        container1.add(new Primitive(2));
        container2.add(new Primitive(3));
        container1.add(container2);
        container1.traverse();
    }
}
