package com.proyectoJava.jpa.proyectoJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI proyectoJavaOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Proyecto Java - CoderHouse")
                        .description("API de administración de libros y compras")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
