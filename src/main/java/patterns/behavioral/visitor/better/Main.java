package patterns.behavioral.visitor.better;

public class Main {

    public static void main(String[] args) {
        Folder folder = new Folder("root", new Folder("empty", new File("inside-file")),
                new File("file1"), new File("file2"));

        Visitor visitor = element -> System.out.println(element.getName());
        folder.accept(visitor);
    }
}
