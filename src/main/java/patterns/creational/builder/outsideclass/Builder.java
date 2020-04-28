package patterns.creational.builder.outsideclass;

import patterns.creational.builder.outsideclass.component.Engine;
import patterns.creational.builder.outsideclass.component.GPSNavigator;
import patterns.creational.builder.outsideclass.component.Transmission;
import patterns.creational.builder.outsideclass.component.TripComputer;
import patterns.creational.builder.outsideclass.product.Type;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setType(Type type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
