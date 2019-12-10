package guru.springframework.RecipeApp.services.ımp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.RecipeApp.model.Recipe;
import guru.springframework.RecipeApp.repositories.RecipeRepository;
import guru.springframework.RecipeApp.services.RecipeService;

@Service
public class RecipeServiceImp implements RecipeService{
	private final RecipeRepository recipeRepository;
	
	@Autowired
	public RecipeServiceImp(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
		

	@Override
	public Set<Recipe> getRecipes() {
		System.out.println("I'm in the service");
		
		Set<Recipe> recipes = new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes :: add);
		return recipes;
	}

}
