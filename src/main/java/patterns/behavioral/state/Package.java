package patterns.behavioral.state;

public class Package {

    PackageState state;

    public Package() {
        state = new OrderedState();
    }

    public void setState(PackageState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }

    public void prev() {
        state.prev(this);
    }

    public void printStatus() {
        state.printStatus();
    }

}
