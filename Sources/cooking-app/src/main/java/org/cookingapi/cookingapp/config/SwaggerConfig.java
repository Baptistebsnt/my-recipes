package org.cookingapi.cookingapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("My Recipes API")
                        .version("1.0")
                        .description("API for managing recipes, ingredients, and cooking instructions."));
    }
}
