package org.example.compulsory;

import com.github.javafaker.Faker;

public class EnemyLocation extends Location {
    public EnemyLocation(Faker faker) {
        super(LocationType.ENEMY, faker);
    }
}
