package compulsory;

public class Drone extends Aircraft implements CargoCapable {

    private double batteryLife;
    private double maxPayload;

    public Drone(String model, String tailNumber, double batteryLife, double maxPayload) {
        super(model, tailNumber);
        this.batteryLife = batteryLife;
        this.maxPayload = maxPayload;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }

    public double getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(double maxPayload) {
        this.maxPayload = maxPayload;
    }


    @Override
    public double getMaximumPayload() {
        return maxPayload;
    }

    @Override
    public String toString() {
        return super.toString() + ", Max Payload: " + maxPayload;
    }

}
