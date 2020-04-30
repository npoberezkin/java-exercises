package patterns.behavioral.command;

public class SaveFileOpetion implements FileOperation {

    File file;

    public SaveFileOpetion(File file) {
        this.file = file;
    }

    @Override
    public void execute() {
        file.save();
    }
}
