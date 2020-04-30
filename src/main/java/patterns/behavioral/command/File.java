package patterns.behavioral.command;

public class File {

    private String name;

    public File(String name){
        this.name = name;
    }

    public void open(){
        System.out.println("open file " + name);
    }

    public void save(){
        System.out.println("save file " + name);
    }
}
