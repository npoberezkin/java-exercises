package patterns.singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton instance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
