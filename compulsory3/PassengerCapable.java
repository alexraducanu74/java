package compulsory3;

public interface PassengerCapable {

    default boolean hasBusinessClassSeats() {
        return true;
    }
}