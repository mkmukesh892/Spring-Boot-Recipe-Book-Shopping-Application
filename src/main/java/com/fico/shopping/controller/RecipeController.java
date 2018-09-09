package com.fico.shopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fico.shopping.exception.ResourceNotFoundException;
import com.fico.shopping.model.Recipe;
import com.fico.shopping.repository.RecipeRepository;

@RestController
@RequestMapping("/shopping-api")
public class RecipeController {
@Autowired
private RecipeRepository recipeRepository;
@GetMapping("/recipes")
public List<Recipe> getAllNotes() {
	return recipeRepository.findAll();
}
@PostMapping("/recipes")
public Recipe createRecipe(@Valid @RequestBody Recipe recipe) {
	return recipeRepository.save(recipe);
}
@GetMapping("/recipes/{id}") 
public Recipe getRecipeById(@PathVariable(value="id") Integer recipeId) {
	return recipeRepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));
}
@PutMapping("/recipes/{id}")
public Recipe updateNote(@PathVariable(value = "id") Integer recipeId,
                                        @Valid @RequestBody Recipe recipeDetails) {

    Recipe recipe = recipeRepository.findById(recipeId)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", recipeId));

    recipe.setName(recipeDetails.getName());
    recipe.setDescription(recipeDetails.getDescription());
    recipe.setImagepath(recipeDetails.getImagepath());
    recipe.setIngredients(recipeDetails.getIngredients());
    Recipe updatedNote = recipeRepository.save(recipe);
    return updatedNote;
}
@DeleteMapping("/recipes/{id}")
public ResponseEntity<?> deleteRecipe(@PathVariable(value="id") Integer recipeId) {
	Recipe recipe = recipeRepository.findById(recipeId)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", recipeId));
	recipeRepository.delete(recipe);
	return ResponseEntity.ok().build();
}
}
