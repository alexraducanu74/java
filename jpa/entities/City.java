package org.example.jpa.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name LIKE :name")
})
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private boolean isCapital;
    private double latitude;
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;




    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

