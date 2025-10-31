package de.jan.czok.superdupermarkt.model;

import java.time.LocalDate;

public class Cheese extends Product {
    public Cheese(String name, int quality, LocalDate expiryDate, double basePrice, LocalDate createdAt) {
        super(name, quality, expiryDate, basePrice, createdAt);
    }

    @Override
    public void updateDaily(LocalDate currentDay) {
        if (quality > 0) quality = quality - 1;
    }

    @Override
    public double getCurrentPrice(LocalDate currentDay) {
        return basePrice + 0.10 * quality;
    }

    @Override
    public boolean shouldBeRemoved(LocalDate currentDay) {
        boolean lowQuality = quality < 30;
        boolean expired = expiryDate != null && (currentDay.isAfter(expiryDate) || currentDay.isEqual(expiryDate));
        return lowQuality || expired;
    }
}
