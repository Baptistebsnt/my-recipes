package org.cookingapi.cookingapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Recipe")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    @Schema(description = "Unique identifier of the recipe", example = "1")
    private Long id;

    @Schema(description = "Name of the recipe", example = "Spaghetti Bolognese")
    private String name;

    @Schema(description = "Description of the recipe", example = "A classic Italian pasta dish with rich meat sauce.")
    private String description;

    @Schema(description = "List of ingredients required for the recipe", example = "[\"200g spaghetti\", \"100g minced beef\", \"1 onion\", \"2 cloves garlic\"]")
    private String[] ingredients;

    @Schema(description = "Cooking instructions for the recipe", example = "1. Boil the spaghetti. 2. Cook the minced beef with onion and garlic. 3. Combine and serve.")
    private String instructions;
}
