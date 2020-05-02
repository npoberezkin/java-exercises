package patterns.behavioral.state;

public class OrderedState implements PackageState {
    @Override
    public void next(Package pack) {
        pack.setState(new DeliveredState());
    }

    @Override
    public void prev(Package pack) {
        System.out.println("The package is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Package ordered, not delivered to the office yet.");
    }
}
