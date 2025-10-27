package org.cookingapi.cookingapp.controller;

import org.cookingapi.cookingapp.dto.RecipeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    // GET /api/recipes
    @GetMapping
    public ResponseEntity<List<RecipeDto>> getAllRecipes() {
        RecipeDto sample = new RecipeDto(1L, "Spaghetti Bolognese",
                "A classic Italian pasta dish with rich meat sauce.",
                new String[]{"200g spaghetti", "100g minced beef", "1 onion", "2 cloves garlic"},
                "1. Boil the spaghetti. 2. Cook the minced beef with onion and garlic. 3. Combine and serve.");

        return ResponseEntity.ok(List.of(sample));
    }

    // GET /api/recipes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id) {
        RecipeDto sample = new RecipeDto(id, "Tarte Tatin",
                "A classic French upside-down apple tart.",
                new String[]{"6 apples", "100g sugar", "50g butter", "1 sheet puff pastry"},
                "1. Caramelize sugar and butter. 2. Add apples and cook. 3. Cover with pastry and bake.");
        return ResponseEntity.ok(sample);
    }

    // POST /api/recipes
    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto) {
        recipeDto.setId(1L);
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeDto);
    }


}
