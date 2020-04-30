package patterns.behavioral.interpreter;

public class Main {

    public static void main(String[] args) {
        Expression query = new Select("name", new From("people"));
        Context ctx = new Context();
        query.interpret(ctx);
    }
}
