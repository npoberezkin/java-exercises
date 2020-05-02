package patterns.behavioral.state;

public interface PackageState {

    void next(Package pack);

    void prev(Package pack);

    void printStatus();
}
