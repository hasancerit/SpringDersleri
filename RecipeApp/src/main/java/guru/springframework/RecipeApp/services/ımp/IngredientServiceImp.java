package guru.springframework.RecipeApp.services.ımp;

import java.util.Optional;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import guru.springframework.RecipeApp.commands.IngredientCommand;
import guru.springframework.RecipeApp.converters.IngredientToIngredientCommand;
import guru.springframework.RecipeApp.model.Recipe;
import guru.springframework.RecipeApp.repositories.RecipeRepository;
import guru.springframework.RecipeApp.services.IngredientService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IngredientServiceImp implements IngredientService{
	private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImp(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if (!recipeOptional.isPresent())
            log.error("recipe id not found. Id: " + recipeId);
        Recipe recipe = recipeOptional.get();
        
        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId() == ingredientId)
                .map( ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if(!ingredientCommandOptional.isPresent())
        	log.error("Ingredient id not found: " + ingredientId);
        
        return ingredientCommandOptional.get();
    }
}
