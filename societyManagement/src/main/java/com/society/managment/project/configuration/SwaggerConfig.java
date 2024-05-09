package com.society.managment.project.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "Society Management API",
        description = "API for managing society operations",
        termsOfService = "Terms and Conditions",
        version = "v1"
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Development Server"),
        @Server(url = "http://test.example.com", description = "Testing Server")
    }
)
public class SwaggerConfig {
   
}
