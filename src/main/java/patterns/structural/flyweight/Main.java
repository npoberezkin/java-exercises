package patterns.structural.flyweight;

public class Main {

    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle blueVehicle = vehicleFactory.getVehicle(Color.BLUE);
        Vehicle greenVehicle = vehicleFactory.getVehicle(Color.GREEN);
        Vehicle redVehicle = vehicleFactory.getVehicle(Color.RED);
        Vehicle sameGreenVehicle = vehicleFactory.getVehicle(Color.GREEN);

        System.out.println(blueVehicle.hashCode());
        System.out.println(redVehicle.hashCode());
        System.out.println(greenVehicle.hashCode());
        System.out.println(sameGreenVehicle.hashCode());
    }
}
