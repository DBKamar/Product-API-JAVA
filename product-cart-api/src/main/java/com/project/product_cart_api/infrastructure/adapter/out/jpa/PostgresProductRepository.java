package com.project.product_cart_api.infrastructure.adapter.out.jpa;

import com.project.product_cart_api.domain.model.Product;
import com.project.product_cart_api.domain.port.out.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PostgresProductRepository implements ProductRepository {

    private final JpaProductRepository jpaRepo;

    public PostgresProductRepository(JpaProductRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity(
                product.getId(),
                product.getName(),
                product.getPrice()
        );

        ProductEntity saved = jpaRepo.save(entity);

        return new Product(
                saved.getId(),
                saved.getName(),
                saved.getPrice()
        );
    }

    @Override
    public List<Product> findAll() {
        return jpaRepo.findAll().stream()
                .map(e -> new Product(e.getId(), e.getName(), e.getPrice()))
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepo.deleteById(id);
    }
}
