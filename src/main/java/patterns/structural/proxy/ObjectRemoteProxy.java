package patterns.structural.proxy;

public class ObjectRemoteProxy implements Object {

    private Object object;

    public ObjectRemoteProxy() {
        this.object = new ObjectImpl();
    }

    @Override
    public void process() {
        connectToRemote();
        object.process();
    }

    private void connectToRemote() {
        System.out.println("connecting to remote..");
    }
}
