package patterns.singleton;

public class StaticBlockSingleton {

    private static final StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    //static block initialization for exception handling
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred while creating singleton instance");
        }
    }

    public static StaticBlockSingleton instance() {
        return instance;
    }
}
