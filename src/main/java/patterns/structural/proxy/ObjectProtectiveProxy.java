package patterns.structural.proxy;

public class ObjectProtectiveProxy implements Object {

    private Object object;

    public ObjectProtectiveProxy() {
        this.object = new ObjectImpl();
    }

    @Override
    public void process() {
        authorizeAccess();
        object.process();
    }

    private void authorizeAccess() {
        System.out.println("authorizing access..");
    }
}
