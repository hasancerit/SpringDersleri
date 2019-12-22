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
        	System.out.println("Log1");

            if(ingredientOptional.isPresent()){
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUom(unitOfMeasureRepository
                        .findById(command.getUom().getId())
                        .orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); //todo address this

            } else {
            	System.out.println("Log2");
                //add new Ingredient
            	Ingredient ingredient = ingredientCommandToIngredient.convert(command);
            	ingredient.setRecipe(recipe);
                recipe.addIngredient(ingredient);
            	System.out.println("Log3");

            }
            
            Recipe savedRecipe = recipeRepository.save(recipe);
        	System.out.println("Log4");

            Optional<Ingredient> savedIngredientOptional = savedRecipe.getIngredients().stream()
                    .filter(recipeIngredients -> (recipeIngredients.getId()+"").equals(""+command.getId()))
                    .findFirst();
        	System.out.println("Log5");

            //check by description
            if(!savedIngredientOptional.isPresent()){
            	System.out.println("Log6");

                //not totally safe... But best guess
                savedIngredientOptional = savedRecipe.getIngredients().stream()
                        .filter(recipeIngredients -> recipeIngredients.getDescription().equals(command.getDescription()))
                        .filter(recipeIngredients -> recipeIngredients.getAmount().equals(command.getAmount()))
                        .filter(recipeIngredients -> (recipeIngredients.getUom().getId()+"").equals(""+(command.getUom().getId())))
                        .findFirst();
            	System.out.println("Log7");

            }
        	System.out.println("Log8");

            //to do check for fail
            return ingredientToIngredientCommand.convert(savedIngredientOptional.get());
        }

    }
}
