package com.shopme.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.shopme.common.entities", "com.shopme.admin.repositories"})
public class ShopmeBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopmeBackEndApplication.class, args);
	}

}
