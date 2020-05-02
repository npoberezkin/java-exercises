package patterns.behavioral.templatemethod;

public abstract class ComputerBuilder {

    final public void buildComputer(){
        addInternalComponents();
        addExternalComputers();
    }

    public abstract void addInternalComponents();

    public abstract void addExternalComputers();
}
