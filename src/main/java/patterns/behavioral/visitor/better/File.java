package patterns.behavioral.visitor.better;

public class File implements Element {

    String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }
}
