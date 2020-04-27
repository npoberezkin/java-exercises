package patterns.creational.singleton;

import java.lang.reflect.Constructor;

public class SingletonReflectionBreaker {

    public static void main(String[] args) {
        EagerSingleton instanceOne = EagerSingleton.instance();
        EagerSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
