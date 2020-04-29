package patterns.structural.proxy;

public class ObjectImpl implements Object {

    public ObjectImpl() {
        heavyInitialization();
    }

    @Override
    public void process() {
        System.out.println("processing..");
    }

    public void heavyInitialization() {
        System.out.println("heavy initialization is in process..");
    }
}
