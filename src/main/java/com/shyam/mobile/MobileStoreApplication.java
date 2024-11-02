package com.shyam.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootConfiguration
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MobilePhone Portal",version = "1.0"))
public class MobileStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileStoreApplication.class, args);
	}

}
