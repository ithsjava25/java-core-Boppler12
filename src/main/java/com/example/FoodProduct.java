package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


public class FoodProduct extends Product implements Perishable, Shippable{
    private final LocalDate expirationDate;
    private final Double weight;

    public FoodProduct(UUID id, String name, Category category, BigDecimal price, LocalDate expirationDate, Double weight){
        super(id, name, category, price);
        this.expirationDate= expirationDate;
        this.weight= weight;
    }

    @Override
    public LocalDate expirationDate() {
        return expirationDate;
    }

    @Override
    public BigDecimal calculateShippingCost() {
        BigDecimal baseCost= BigDecimal.valueOf(5.0);
        BigDecimal weightFactor= BigDecimal.valueOf(weight * 0.5);
        return baseCost.add(weightFactor);
    }

    @Override
    public Double weight() {
        return weight;
    }

    @Override
    public String productDetails() {
        return "Food Product: " + super.id() + ", Expiration Date: " + expirationDate.toString() + ", Weight: " + weight + "kg";
    }
}