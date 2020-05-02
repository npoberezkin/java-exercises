package patterns.behavioral.templatemethod;

public class Main {

    public static void main(String[] args) {
        ComputerBuilder highEndComputerBuilder = new HighEndComputerBuilder();
        ComputerBuilder lowEndComputerBuilder = new LowEndComputerBuilder();

        highEndComputerBuilder.buildComputer();
        lowEndComputerBuilder.buildComputer();
    }
}
