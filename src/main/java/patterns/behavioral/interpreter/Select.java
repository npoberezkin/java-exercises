package patterns.behavioral.interpreter;

public class Select implements Expression {

    String column;
    From from;

    public Select(String column, From from) {
        this.column = column;
        this.from = from;
    }

    @Override
    public void interpret(Context ctx) {
        ctx.setColumn(column);
        from.interpret(ctx);
    }
}
