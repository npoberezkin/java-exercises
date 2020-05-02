package patterns.behavioral.state;

public class ReceivedState implements PackageState {
    @Override
    public void next(Package pack) {
        System.out.println("This package is already received by a client.");
    }

    @Override
    public void prev(Package pack) {
        pack.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package received.");
    }
}
