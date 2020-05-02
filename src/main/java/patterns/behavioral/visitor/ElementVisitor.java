package patterns.behavioral.visitor;

public class ElementVisitor implements Visitor {

    @Override
    public void visit(XmlElement xe) {
        System.out.println(
                "processing an XML element");
    }

    @Override
    public void visit(JsonElement je) {
        System.out.println(
                "processing a JSON element");
    }
}