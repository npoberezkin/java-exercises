package patterns.behavioral.visitor.better;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Folder implements Element {

    String name;
    List<Element> elementList;

    public Folder(String name, Element... elements) {
        this.name = name;
        this.elementList = new ArrayList<>(Arrays.asList(elements));
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
    }

    @Override
    public void accept(Visitor v) {
        for (Element element : elementList) {
            element.accept(v);
        }
        v.visit(this);
    }

    @Override
    public String getName() {
        return "folder " + name;
    }
}
