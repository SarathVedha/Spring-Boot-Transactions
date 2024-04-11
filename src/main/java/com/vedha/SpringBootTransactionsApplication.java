package com.vedha;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot Transactions", version = "1.0", description = "Spring Boot Transactions"))
public class SpringBootTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionsApplication.class, args);
	}

}
