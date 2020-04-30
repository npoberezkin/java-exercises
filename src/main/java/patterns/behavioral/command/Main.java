package patterns.behavioral.command;

public class Main {

    public static void main(String[] args) {
        FileOperationExecutor fileOperationExecutor = new FileOperationExecutor();
        File file = new File("file.txt");
        fileOperationExecutor.executeOperation(new OpenFileOperation(file));
        fileOperationExecutor.executeOperation(new SaveFileOpetion(file));

        // or

        fileOperationExecutor.executeOperation(() -> new OpenFileOperation(file).execute());
        fileOperationExecutor.executeOperation(() -> new SaveFileOpetion(file).execute());

        // or

        fileOperationExecutor.executeOperation(file::open);
        fileOperationExecutor.executeOperation(file::save);
    }
}
