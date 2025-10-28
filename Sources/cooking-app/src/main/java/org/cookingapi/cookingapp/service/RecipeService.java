package org.cookingapi.cookingapp.service;

import lombok.RequiredArgsConstructor;
import org.cookingapi.cookingapp.dto.RecipeDto;
import org.cookingapi.cookingapp.entity.Recipe;
import org.cookingapi.cookingapp.repository.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<RecipeDto> getAllRecipes(){
        return recipeRepository.findAll()
                .stream()
                .map(recipe -> modelMapper.map(recipe, RecipeDto.class))
                .collect(Collectors.toList());
    }

    public RecipeDto getRecipeById(Long id){
    Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
        return modelMapper.map(recipe, RecipeDto.class);
    }

    public RecipeDto createRecipe(RecipeDto recipeDto){
        Recipe recipe = modelMapper.map(recipeDto, Recipe.class);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return modelMapper.map(savedRecipe, RecipeDto.class);
    }

    public RecipeDto updateRecipe(Long id, RecipeDto recipeDto){
        Recipe existingRecipe = recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
        existingRecipe.setTitle(recipeDto.getTitle());
        existingRecipe.setDescription(recipeDto.getDescription());
        existingRecipe.setInstructions(recipeDto.getInstructions());
        existingRecipe.setPreparationTime(recipeDto.getPreparationTime());
        Recipe updatedRecipe = recipeRepository.save(existingRecipe);
        return modelMapper.map(updatedRecipe, RecipeDto.class);
    }

    public void deleteRecipe(Long id){
        recipeRepository.deleteById(id);
    }

}
