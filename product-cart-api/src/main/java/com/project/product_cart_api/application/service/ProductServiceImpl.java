package com.project.product_cart_api.application.service;

import com.project.product_cart_api.domain.model.Product;
import com.project.product_cart_api.domain.port.in.ProductUseCase;
import com.project.product_cart_api.domain.port.out.ProductRepository;

import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductUseCase {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(String name, double price) {
        return repository.save(new Product(UUID.randomUUID(), name, price));
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
