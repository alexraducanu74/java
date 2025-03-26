package org.example.compulsory;

import com.github.javafaker.Faker;

public class FriendlyLocation extends Location {
    public FriendlyLocation(Faker faker) {
        super(LocationType.FRIENDLY, faker);
    }
}