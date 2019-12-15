package guru.springframework.RecipeApp.services;

import java.util.Set;

import guru.springframework.RecipeApp.commands.RecipeCommand;
import guru.springframework.RecipeApp.model.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipes();

	Recipe findById(Long l);

	RecipeCommand saveRecipeCommand(RecipeCommand command);

	RecipeCommand findCommandById(Long l);
	
	
}
