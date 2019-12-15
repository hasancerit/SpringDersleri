package guru.springframework.RecipeApp.services;

import guru.springframework.RecipeApp.commands.IngredientCommand;

public interface IngredientService {

	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

}
