package compulsory;

public interface PassengerCapable {

    default boolean hasBusinessClassSeats() {
        return true;
    }
}