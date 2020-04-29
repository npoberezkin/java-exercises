package patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {

    private static Map<Color, Vehicle> vehicleCache = new HashMap<>();

    public Vehicle getVehicle(Color color) {
        Vehicle vehicle = vehicleCache.computeIfAbsent(color, newColor -> {
            return new Car(newColor);
        });
        return vehicle;
    }
}
