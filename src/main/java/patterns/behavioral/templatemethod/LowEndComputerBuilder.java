package patterns.behavioral.templatemethod;

public class LowEndComputerBuilder extends ComputerBuilder {

    @Override
    public void addInternalComponents() {
        System.out.println("adding low-end internal components");
    }

    @Override
    public void addExternalComputers() {
        System.out.println("adding low-end external components");
    }
}
