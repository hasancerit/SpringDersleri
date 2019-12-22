package guru.springframework.RecipeApp.services.ımp;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import guru.springframework.RecipeApp.commands.IngredientCommand;
import guru.springframework.RecipeApp.converters.IngredientCommandToIngredient;
import guru.springframework.RecipeApp.converters.IngredientToIngredientCommand;
import guru.springframework.RecipeApp.model.Ingredient;
import guru.springframework.RecipeApp.model.Recipe;
import guru.springframework.RecipeApp.repositories.RecipeRepository;
import guru.springframework.RecipeApp.repositories.UnitOfMeausureRepository;
import guru.springframework.RecipeApp.services.IngredientService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IngredientServiceImp implements IngredientService{
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeausureRepository unitOfMeasureRepository;

    public IngredientServiceImp(IngredientToIngredientCommand ingredientToIngredientCommand,
                                 IngredientCommandToIngredient ingredientCommandToIngredient,
                                 RecipeRepository recipeRepository, UnitOfMeausureRepository unitOfMeasureRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
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
    
    @Override
    @Transactional
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());
        if(!recipeOptional.isPresent()){
            log.error("Recipe not found for id: " + command.getRecipeId());
            return new IngredientCommand();
        } else {
            Recipe recipe = recipeOptional.get();
            
            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> (""+ingredient.getId()).equals(""+command.getId()))
                    .findFirst();

            if(ingredientOptional.isPresent()){
                System.out.println("TEST");
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUom(unitOfMeasureRepository
                        .findById(command.getUom().getId())
                        .orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); //todo address this

            } else {
                //add new Ingredient
                recipe.addIngredient(ingredientCommandToIngredient.convert(command));
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            //to do check for fail
            return ingredientToIngredientCommand.convert(savedRecipe.getIngredients().stream()
                    .filter(recipeIngredients -> (""+recipeIngredients.getId()).equals(""+command.getId()))
                    .findFirst()
                    .get());
        }

    }
}
