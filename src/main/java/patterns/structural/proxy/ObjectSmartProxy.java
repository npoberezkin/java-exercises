package patterns.structural.proxy;

public class ObjectSmartProxy implements Object {

    private Object object;

    public ObjectSmartProxy() {
        this.object = new ObjectImpl();
    }

    @Override
    public void process() {
        makeAdditionalAction();
        object.process();
    }

    public void makeAdditionalAction() {
        System.out.println("making additional action..");
    }
}
