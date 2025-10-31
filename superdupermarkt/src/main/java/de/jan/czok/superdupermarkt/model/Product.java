package de.jan.czok.superdupermarkt.model;

import java.time.LocalDate;

public abstract class Product {
    protected String name;
    protected int quality;
    protected LocalDate expiryDate;
    protected double basePrice;
    protected LocalDate createdAt;

    public Product(String name, int quality, LocalDate expiryDate, double basePrice, LocalDate createdAt) {
        this.name = name;
        this.quality = quality;
        this.expiryDate = expiryDate;
        this.basePrice = basePrice;
        this.createdAt = createdAt;
    }

    public String getName() { return name; }
    public int getQuality() { return quality; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public double getBasePrice() { return basePrice; }
    public LocalDate getCreatedAt() { return createdAt; }

    public abstract void updateDaily(LocalDate currentDay);

    public abstract double getCurrentPrice(LocalDate currentDay);

    public abstract boolean shouldBeRemoved(LocalDate currentDay);

}
