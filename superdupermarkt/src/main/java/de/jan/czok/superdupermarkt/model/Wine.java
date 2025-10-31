package de.jan.czok.superdupermarkt.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Wine extends Product {
    public Wine(String name, int quality, LocalDate expiryDate, double basePrice, LocalDate createdAt) {
        super(name, quality, expiryDate, basePrice, createdAt);
    }

    @Override
    public void updateDaily(LocalDate currentDay) {
        long daysFromCreated = ChronoUnit.DAYS.between(createdAt, currentDay);
        if (daysFromCreated > 0 && daysFromCreated % 10 == 0 && quality < 50) {
            quality = quality + 1;
        }
    }

    @Override
    public double getCurrentPrice(LocalDate currentDay) {
        return basePrice; // Preis bleibt konstant
    }

    @Override
    public boolean shouldBeRemoved(LocalDate currentDay) {
        return false;
    }
}
