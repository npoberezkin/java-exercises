package patterns.behavioral.chainofresponsibility;

public abstract class AuthenticationProcess {

    AuthenticationProcess next;

    public AuthenticationProcess(AuthenticationProcess next) {
        this.next = next;
    }

    public abstract boolean isAuthorized(AuthenticationProvider provider);
}
