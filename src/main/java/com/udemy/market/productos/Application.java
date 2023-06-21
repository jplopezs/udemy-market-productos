package com.udemy.market.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.udemy.market.productos.model"})
@EnableJpaRepositories(basePackages = {"com.udemy.market.productos.repository"})
@SpringBootApplication(scanBasePackages = {"com.udemy.market.productos.service", "com.udemy.market.productos.controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
