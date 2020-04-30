package patterns.behavioral.chainofresponsibility;

public class Main {

    public static void main(String[] args) {
        AuthenticationProcess chain = new OAuthProcess(new LoginPasswordProcess(null));

        OAuthProvider oAuthProvider = new OAuthProvider();
        LoginPasswordProvider loginPasswordProvider = new LoginPasswordProvider();
        SamlProvider samlProvider = new SamlProvider();

        System.out.println(chain.isAuthorized(oAuthProvider));
        System.out.println(chain.isAuthorized(loginPasswordProvider));
        System.out.println(chain.isAuthorized(samlProvider));
    }
}
