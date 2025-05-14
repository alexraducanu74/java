package org.example.lab8;

public class City extends AbstractEntity{
    private final int id;
    private final String name;
    private final int countryId;
    private final boolean isCapital;
    private final double latitude;
    private final double longitude;

    public City(int id, String name, int countryId, boolean isCapital, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.isCapital = isCapital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}
