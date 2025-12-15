package com.project.product_cart_api.infrastructure.adapter.in;

import com.project.product_cart_api.domain.model.Product;
import com.project.product_cart_api.domain.port.in.ProductUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductUseCase useCase;

    public ProductController(ProductUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return useCase.create(product.getName(), product.getPrice());
    }

    @GetMapping
    public List<Product> findAll() {
        return useCase.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        useCase.delete(id);
    }
}
