package patterns.structural.adapter;

public class MovableAdapterImpl implements MovableAdapter {

    private Movable luxuryCar;

    public MovableAdapterImpl(Movable movable) {
        this.luxuryCar = movable;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCar.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
