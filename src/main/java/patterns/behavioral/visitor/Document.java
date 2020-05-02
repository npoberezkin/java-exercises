package patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class Document extends Element {

    List<Element> elements = new ArrayList<>();

    public void addElement(Element element) {
        this.elements.add(element);
    }

    @Override
    public void accept(Visitor v) {
        for (Element e : this.elements) {
            e.accept(v);
        }
    }
}