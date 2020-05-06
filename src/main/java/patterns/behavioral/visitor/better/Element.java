package patterns.behavioral.visitor.better;

public interface Element {

    void accept(Visitor v);

    String getName();
}
