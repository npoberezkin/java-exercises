package patterns.behavioral.state;

public class DeliveredState implements PackageState {
    @Override
    public void next(Package pack) {
        pack.setState(new ReceivedState());
    }

    @Override
    public void prev(Package pack) {
        pack.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package delivered to post office, not received yet.");
    }
}
