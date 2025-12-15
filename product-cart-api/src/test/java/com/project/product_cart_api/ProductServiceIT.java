package com.project.product_cart_api;

import com.project.product_cart_api.config.AbstractPostgresContainerTest;
import com.project.product_cart_api.domain.port.out.ProductRepository;
import com.project.product_cart_api.application.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceIT extends AbstractPostgresContainerTest {

    @Autowired
    ProductServiceImpl service;

    @Autowired
    ProductRepository repository;

    @Test
    void should_store_product_in_postgres_container() {
        service.create("Laptop", 1200);

        var products = service.findAll();

        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo("Laptop");
    }
}
