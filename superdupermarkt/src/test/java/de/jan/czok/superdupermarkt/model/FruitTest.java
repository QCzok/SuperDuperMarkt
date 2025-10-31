package de.jan.czok.superdupermarkt.model;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FruitTest {
    @Test
    void fruitLosesTwoQualityPerDay() {
        LocalDate today = LocalDate.now();
        Fruit fruit = new Fruit("Apple", 30, today.plusDays(10), 1.00, today);

        fruit.updateDaily(today.plusDays(1));
        assertEquals(28, fruit.getQuality());
    }

    @Test
    void fruitSpoilsQuicklyNearExpiry() {
        LocalDate today = LocalDate.now();
        Fruit fruit = new Fruit("Banana", 25, today.plusDays(2), 1.00, today);

        fruit.updateDaily(today.plusDays(1)); // 1 day before expiry
        assertEquals(20, fruit.getQuality()); // -5
    }

    @Test
    void fruitShouldBeRemovedWhenQualityBelow20() {
        LocalDate today = LocalDate.now();
        Fruit fruit = new Fruit("Pear", 18, today.plusDays(5), 1.00, today);

        assertTrue(fruit.shouldBeRemoved(today.plusDays(1)));
    }
}
