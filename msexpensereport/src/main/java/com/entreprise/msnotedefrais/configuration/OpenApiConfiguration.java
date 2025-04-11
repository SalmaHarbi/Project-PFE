package com.entreprise.msnotedefrais.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MSUtilisateur API")
                        .description("implement msUtilisateur APIS")
                        .contact(new Contact()
                                .name("Salma Harbi")
                        )
                );
    }
}