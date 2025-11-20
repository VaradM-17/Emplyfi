package com.varad.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info
(title = "Emplify", description = "Employee Management System", version = "v1.0", 
contact = @Contact(name = "Varad", email = "varadmule17@gmail.com", url = "https://github.com/VaradM-17/Emplify"), 
license = @License(name = "varad mule", url = "https://github.com/VaradM-17/Emplify")), 
externalDocs = @ExternalDocumentation(description = "Employee Management System", url = "https://github.com/VaradM-17/Emplify"))
@SpringBootApplication
public class EmplifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmplifyApplication.class, args);
		System.out.println("Application started....");
	}

}
