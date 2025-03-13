package compulsory3;

public class Freighter extends Aircraft implements CargoCapable {
    private double maxPayload;

    public Freighter(String model, String tailNumber, double maxPayload) {
        super(model, tailNumber);
        this.maxPayload = maxPayload;
    }

    public void setMaxPayload(double maxPayload) {
        this.maxPayload = maxPayload;
    }


    @Override
    public String toString() {
        return super.toString() + ", Max Payload: " + maxPayload;
    }

    @Override
    public double getMaximumPayload() {
        return maxPayload;
    }
}