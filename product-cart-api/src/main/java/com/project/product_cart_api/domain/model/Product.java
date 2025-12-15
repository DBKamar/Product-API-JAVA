package com.project.product_cart_api.domain.model;

import java.util.UUID;

public class Product {

    private final UUID id;
    private final String name;
    private final double price;

    public Product(UUID id, String name, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
