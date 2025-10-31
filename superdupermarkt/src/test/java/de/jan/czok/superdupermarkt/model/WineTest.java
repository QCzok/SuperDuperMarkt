package de.jan.czok.superdupermarkt.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WineTest {
    @Test
    void wineQualityIncreasesEvery10Days() {
        LocalDate start = LocalDate.of(2025, 1, 1);
        Wine wine = new Wine("Bordeaux", 20, null, 10.00, start);

        wine.updateDaily(start.plusDays(10)); // nach 10 Tagen
        assertEquals(21, wine.getQuality());
    }

    @Test
    void winePriceRemainsConstant() {
        LocalDate start = LocalDate.now();
        Wine wine = new Wine("Chianti", 48, null, 12.00, start);

        assertEquals(12.00, wine.getCurrentPrice(start.plusDays(20)));
    }

    @Test
    void wineNeverExpires() {
        LocalDate start = LocalDate.now();
        Wine wine = new Wine("Merlot", 45, null, 9.50, start);

        assertFalse(wine.shouldBeRemoved(start.plusYears(3)));
    }
}
