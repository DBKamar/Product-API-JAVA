package com.project.product_cart_api.infrastructure.config;

import com.project.product_cart_api.application.service.ProductServiceImpl;
import com.project.product_cart_api.domain.port.in.ProductUseCase;
import com.project.product_cart_api.domain.port.out.ProductRepository;
import com.project.product_cart_api.infrastructure.adapter.out.InMemoryProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    ProductRepository productRepository() {
        return new InMemoryProductRepository();
    }

    @Bean
    ProductUseCase productUseCase(ProductRepository repository) {
        return new ProductServiceImpl(repository);
    }
}
