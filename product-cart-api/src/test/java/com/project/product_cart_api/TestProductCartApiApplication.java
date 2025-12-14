package com.project.product_cart_api;

import org.springframework.boot.SpringApplication;

public class TestProductCartApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductCartApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
