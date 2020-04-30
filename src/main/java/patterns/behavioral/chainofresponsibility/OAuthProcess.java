package patterns.behavioral.chainofresponsibility;

public class OAuthProcess extends AuthenticationProcess {

    public OAuthProcess(AuthenticationProcess next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {
        if (provider instanceof OAuthProvider) {
            System.out.println("oauth authentication..");
            return true;
        }
        if (next != null) {
            System.out.println("oauth authentication failed");
            return next.isAuthorized(provider);
        }
        System.out.println("authentication failed");
        return false;
    }
}
