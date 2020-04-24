package patterns.factory;

public class UnknownPlanTypeException extends Exception {

    public UnknownPlanTypeException(String message) {
        super(message);
    }
}
