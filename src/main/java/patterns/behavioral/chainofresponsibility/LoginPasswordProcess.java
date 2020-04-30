package patterns.behavioral.chainofresponsibility;

public class LoginPasswordProcess extends AuthenticationProcess {

    public LoginPasswordProcess(AuthenticationProcess next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {
        if (provider instanceof LoginPasswordProvider) {
            System.out.println("login/pass authentication..");
            return true;
        }
        if (next != null) {
            System.out.println("login/pass authentication failed");
            return next.isAuthorized(provider);
        }
        System.out.println("authentication failed");
        return false;
    }
}
