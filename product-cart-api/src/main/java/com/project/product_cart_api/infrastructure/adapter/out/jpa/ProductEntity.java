package com.project.product_cart_api.infrastructure.adapter.out.jpa;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    protected ProductEntity() {}

    public ProductEntity(UUID id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // getters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
