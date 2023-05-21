package com.expense.expanseTrackerApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ExpanseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpanseTrackerAppApplication.class, args);
	}

}
