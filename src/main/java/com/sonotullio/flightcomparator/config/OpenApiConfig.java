package com.sonotullio.flightcomparator.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Flight Comparator API")
                        .version("1.0")
                        .description("API for comparing flight options")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact().name("Tuo Nome").url("http://tua-url.com").email("tua-email@domain.com"))
                );
    }
}
