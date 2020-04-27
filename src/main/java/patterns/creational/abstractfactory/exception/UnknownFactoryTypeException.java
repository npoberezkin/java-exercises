package patterns.creational.abstractfactory.exception;

public class UnknownFactoryTypeException extends Exception {

    public UnknownFactoryTypeException(String message) {
        super(message);
    }
}
