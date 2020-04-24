package patterns.singleton;

public class ThreadSafeDoubleCheckSingleton {

    private static ThreadSafeDoubleCheckSingleton instance;

    private ThreadSafeDoubleCheckSingleton() {
    }

    public static ThreadSafeDoubleCheckSingleton instance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
