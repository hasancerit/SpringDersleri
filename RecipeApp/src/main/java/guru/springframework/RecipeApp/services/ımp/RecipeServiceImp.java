package guru.springframework.RecipeApp.services.ımp;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.RecipeApp.commands.RecipeCommand;
import guru.springframework.RecipeApp.converters.RecipeCommandToRecipe;
import guru.springframework.RecipeApp.converters.RecipeToRecipeCommand;
import guru.springframework.RecipeApp.exceptions.NotFoundException;
import guru.springframework.RecipeApp.model.Recipe;
import guru.springframework.RecipeApp.repositories.RecipeRepository;
import guru.springframework.RecipeApp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImp implements RecipeService{
	private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
	
    @Autowired
    public RecipeServiceImp(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }


	@Override
	public Set<Recipe> getRecipes() {
		System.out.println("I'm in the service");
		
		Set<Recipe> recipes = new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes :: add);
		return recipes;
	}
	
	  @Override
	    public Recipe findById(Long l) {

	        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

	        if (!recipeOptional.isPresent()) {
	            throw new NotFoundException("Recipe Not Found, for Id Value:"+l.toString());
	        }
	        
	        return recipeOptional.get();
	    }
	  
	  	@Override
	    @Transactional
	    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
	  		System.out.println("Sonuc");
	  		Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

	        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
	        log.debug("Saved RecipeId:" + savedRecipe.getId());
	        return recipeToRecipeCommand.convert(savedRecipe);
	    }
	  	
		@Override
	    @Transactional
	    public RecipeCommand findCommandById(Long l) {
	        return recipeToRecipeCommand.convert(findById(l));
	    }
		
		@Override
	    @Transactional
	    public void deleteById(Long l) {
	        recipeRepository.deleteById(l);
	    }
}
