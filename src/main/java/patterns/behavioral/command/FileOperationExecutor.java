package patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class FileOperationExecutor {

    private List<FileOperation> operations = new ArrayList<>();

    public void executeOperation(FileOperation operation) {
        operations.add(operation);
        operation.execute();
    }
}
