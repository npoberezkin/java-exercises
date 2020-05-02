package patterns.behavioral.visitor;

public class Main {

    public static void main(String[] args) {
        Document document = new Document();
        Element jsonElement = new JsonElement();
        Element xmlElement = new XmlElement();

        document.addElement(jsonElement);
        document.addElement(xmlElement);

        Visitor elementVisitor = new ElementVisitor();

        document.accept(elementVisitor);
    }
}
