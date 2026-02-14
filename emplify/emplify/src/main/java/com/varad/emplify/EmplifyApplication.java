package com.varad.emplify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Emplify API", version = "v1", description = "Employee and Department management API"))
public class EmplifyApplication {
    private static final Logger logger = LoggerFactory.getLogger(EmplifyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmplifyApplication.class, args);
        logger.info("Emplify Application Started");
    }

}