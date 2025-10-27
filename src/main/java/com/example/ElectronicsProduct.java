package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ElectronicsProduct extends Product implements Shippable{
    private final BigDecimal weight;
    private final int warrantyMonths;

    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warrantyMonths, BigDecimal weight) {
        super(id, name, category, price);
        if (warrantyMonths < 0) {
            throw new IllegalArgumentException("Warranty months cannot be negative.");
        }
        this.warrantyMonths = warrantyMonths;
        this.weight = weight;
    }

    public int warrantyMonths() {
        return warrantyMonths;
    }

    @Override
    public Double weight() {
        return weight.doubleValue();
    }

    @Override
    public BigDecimal calculateShippingCost() {
        BigDecimal baseCost = new BigDecimal("79");
        if (weight.compareTo(new BigDecimal("5.0")) > 0) {
            return baseCost.add(new BigDecimal("49"));
        }
        return baseCost;
    }

    @Override
    public String productDetails() {
        return String.format("Electronics: %s, Warranty: %d months", name(), warrantyMonths);
    }
}
