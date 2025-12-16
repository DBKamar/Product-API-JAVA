package com.project.product_cart_api.infrastructure.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JpaProductRepository
        extends JpaRepository<ProductEntity, UUID> {
}
