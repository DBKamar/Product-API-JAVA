package com.project.product_cart_api.domain.port.in;

import com.project.product_cart_api.domain.model.Product;
import java.util.List;
import java.util.UUID;

public interface ProductUseCase {

    Product create(String name, double price);
    List<Product> findAll();
    void delete(UUID id);
}
