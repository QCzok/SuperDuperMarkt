package de.jan.czok.superdupermarkt.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheeseTest {
    @Test
    void cheeseLosesQualityDaily() {
        LocalDate today = LocalDate.now();
        Cheese cheese = new Cheese("Emmentaler", 35, today.plusDays(60), 2.00, today);

        cheese.updateDaily(today.plusDays(1));
        assertEquals(34, cheese.getQuality());
    }
}
