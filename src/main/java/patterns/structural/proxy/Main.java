package patterns.structural.proxy;

public class Main {

    public static void main(String[] args) {
        ObjectVirtualProxy objectVirtualProxy = new ObjectVirtualProxy();
        objectVirtualProxy.process();
        objectVirtualProxy.process();
        ObjectRemoteProxy objectRemoteProxy = new ObjectRemoteProxy();
        objectRemoteProxy.process();
        ObjectProtectiveProxy objectProtectiveProxy = new ObjectProtectiveProxy();
        objectProtectiveProxy.process();
        ObjectSmartProxy objectSmartProxy = new ObjectSmartProxy();
        objectSmartProxy.process();
    }
}
