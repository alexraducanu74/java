package org.example.compulsory;
import com.github.javafaker.Faker;

public class NeutralLocation extends Location {
    public NeutralLocation(Faker faker) {
        super(LocationType.NEUTRAL, faker);
    }
}