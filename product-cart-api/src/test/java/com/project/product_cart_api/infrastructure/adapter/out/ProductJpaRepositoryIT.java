package com.project.product_cart_api.infrastructure.adapter.out;

import com.project.product_cart_api.infrastructure.adapter.out.jpa.JpaProductRepository;
import com.project.product_cart_api.infrastructure.adapter.out.jpa.ProductEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class ProductJpaRepositoryIT {

    @Container
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16")
                    .withDatabaseName("testdb")
                    .withUsername("testuser")
                    .withPassword("testpass");

    @DynamicPropertySource
    static void registerDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
    }

    @Autowired
    private JpaProductRepository productJpaRepository;

    @Test
    void should_save_and_find_products_in_real_postgres() {
        // GIVEN
        ProductEntity entity = new ProductEntity(
                UUID.randomUUID(),
                "Phone",
                899.99
        );

        // WHEN
        productJpaRepository.save(entity);
        List<ProductEntity> products = productJpaRepository.findAll();

        // THEN
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo("Phone");
        assertThat(products.get(0).getPrice()).isEqualTo(899.99);
    }
}
