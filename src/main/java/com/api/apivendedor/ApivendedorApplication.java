package com.api.apivendedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.api.apivendedor")
public class ApivendedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApivendedorApplication.class, args);
	}

}
