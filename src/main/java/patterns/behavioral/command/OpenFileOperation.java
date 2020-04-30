package patterns.behavioral.command;

public class OpenFileOperation implements FileOperation {

    File file;

    public OpenFileOperation(File file){
        this.file = file;
    }

    @Override
    public void execute() {
        file.open();
    }
}
