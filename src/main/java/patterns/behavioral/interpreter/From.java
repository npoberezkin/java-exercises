package patterns.behavioral.interpreter;

class From implements Expression {

    private String table;
    private Where where;

    public From(String table) {
        this.table = table;
    }

    @Override
    public void interpret(Context ctx) {
        ctx.setTable(table);
        if (where == null) {
            ctx.search();
        } else {
            where.interpret(ctx);
        }
    }
}