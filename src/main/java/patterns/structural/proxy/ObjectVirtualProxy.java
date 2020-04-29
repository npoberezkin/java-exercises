package patterns.structural.proxy;

public class ObjectVirtualProxy implements Object {

    private Object object;

    @Override
    public void process() {
        if (object == null) {
            object = new ObjectImpl();
        }
        object.process();
    }
}
