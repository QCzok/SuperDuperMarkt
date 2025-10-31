package de.jan.czok.superdupermarkt.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fruit extends Product {
    public Fruit(String name, int quality, LocalDate expiryDate, double basePrice, LocalDate createdAt) {
        super(name, quality, expiryDate, basePrice, createdAt);
    }

    /*
    Quality decreases by 2 points per day (faster than cheese)
    If there are only 2 days left until expiry, quality drops by 5 per day instead of 2.
     */
    @Override
    public void updateDaily(LocalDate currentDay) {
        if (expiryDate != null) {
            long daysLeft = ChronoUnit.DAYS.between(currentDay, expiryDate);
            if (daysLeft <= 2) {
                quality = Math.max(0, quality - 5);
            } else {
                quality = Math.max(0, quality - 2);
            }
        } else {
            quality = Math.max(0, quality - 2);
        }
    }

    // basePrice + 0.05 * quality (fruits are cheaper, smaller quality factor).
    @Override
    public double getCurrentPrice(LocalDate currentDay) {
        return basePrice + 0.05 * quality;
    }

    // Must be removed once quality < 20 or expiration date reached
    @Override
    public boolean shouldBeRemoved(LocalDate currentDay) {
        boolean expired = expiryDate != null && (currentDay.isAfter(expiryDate) || currentDay.isEqual(expiryDate));
        return quality < 20 || expired;
    }
}
