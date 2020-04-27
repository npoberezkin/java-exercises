package patterns.creational.factory;

public class UnknownPlanTypeException extends Exception {

    public UnknownPlanTypeException(String message) {
        super(message);
    }
}
