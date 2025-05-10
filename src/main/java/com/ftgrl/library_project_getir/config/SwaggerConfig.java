package com.ftgrl.library_project_getir.config;


import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Library Management System API")
                .version("1.0.0")
                .description("Getir Java Spring Bootcamp Bitirme Projesi - Kütüphane API")
                .contact(new Contact().name("Getir Bootcamp").email("dev@getir.com")));
    }
}

