package patterns.behavioral.templatemethod;

public class HighEndComputerBuilder extends ComputerBuilder {

    @Override
    public void addInternalComponents() {
        System.out.println("adding high-end internal components");
    }

    @Override
    public void addExternalComputers() {
        System.out.println("adding high-end external components");
    }
}
