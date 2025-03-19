package homework;

import compulsory.Aircraft;

import java.time.LocalTime;

public class Flight {
    private String flightId;
    private Aircraft aircraft;
    private TimeInterval landingInterval;

    public Flight(String flightId, Aircraft aircraft, LocalTime start, LocalTime end) {
        this.flightId = flightId;
        this.aircraft = aircraft;
        this.landingInterval = new TimeInterval(start, end);
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public void setLandingInterval(TimeInterval landingInterval) {
        this.landingInterval = landingInterval;
    }

    public TimeInterval getLandingInterval() {
        return landingInterval;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }
}