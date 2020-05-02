package patterns.behavioral.state;

public class Main {

    public static void main(String[] args) {
        Package aPackage = new Package();
        aPackage.printStatus();
        aPackage.next();
        aPackage.printStatus();
        aPackage.next();
        aPackage.printStatus();
    }
}
