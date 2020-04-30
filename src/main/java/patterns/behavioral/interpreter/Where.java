package patterns.behavioral.interpreter;

import java.util.function.Predicate;

class Where implements Expression {

    private Predicate<String> filter;

    public Where(Predicate<String> filter) {
        this.filter = filter;
    }

    @Override
    public void interpret(Context ctx) {
        ctx.setWhereFilter(filter);
        ctx.search();
    }
}