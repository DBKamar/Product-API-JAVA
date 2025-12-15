package com.project.product_cart_api.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.project.product_cart_api.application.service.ProductServiceImpl;
import com.project.product_cart_api.infrastructure.adapter.out.InMemoryProductRepository;

class ProductServiceTest {

    @Test
    void should_create_and_list_products() {
        ProductServiceImpl service =
                new ProductServiceImpl(new InMemoryProductRepository());

        service.create("Laptop", 1200);

        assertThat(service.findAll()).hasSize(1);
        assertThat(service.findAll().get(0).getName()).isEqualTo("Laptop");
    }
}
