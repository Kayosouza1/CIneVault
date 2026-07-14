package com.java.kayo.cinevault.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {


    @Bean
    public OpenAPI openAPI() {

        Contact contact = new Contact();

        contact.name("Kayo");
        contact.email("kayousouza11@gmail.com");


        Info info = new Info();

        info.title("CineVault API.");
        info.description("API para gerenciamento de catalogo de filmes.");
        info.version("V1");
        info.contact(contact);


        return new OpenAPI().info(info);
    }
}
