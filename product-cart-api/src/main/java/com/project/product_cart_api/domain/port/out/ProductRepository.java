package com.project.product_cart_api.domain.port.out;

import com.project.product_cart_api.domain.model.Product;
import java.util.List;
import java.util.UUID;

public interface ProductRepository {

    Product save(Product product);
    List<Product> findAll();
    void deleteById(UUID id);
}
