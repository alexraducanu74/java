package compulsory;

public class Airliner extends Aircraft implements PassengerCapable {
    private int passengerCapacity;

    public Airliner(String model, String tailNumber, int passengerCapacity) {
        super(model, tailNumber);
        this.passengerCapacity = passengerCapacity;
    }


    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Passenger Capacity: " + passengerCapacity;
    }
}