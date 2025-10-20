package com.example;

import java.math.BigDecimal;
import java.util.UUID;

public class ElectornicsProduct extends Product implements Shippable{
    private final Double weight;
    private final int warrentyMonths;

    public ElectornicsProduct(UUID id, String name, Category category, BigDecimal price, Double weight, int warrentyMonths){
        super(id, name, category, price);
        this.weight= weight;
        this.warrentyMonths= warrentyMonths;
    }
}
