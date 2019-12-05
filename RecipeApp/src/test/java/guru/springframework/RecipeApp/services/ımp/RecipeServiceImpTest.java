package guru.springframework.RecipeApp.services.ımp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.RecipeApp.model.Recipe;
import guru.springframework.RecipeApp.repositories.RecipeRepository;

public class RecipeServiceImpTest {
	
	RecipeServiceImp recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		recipeService = new RecipeServiceImp(recipeRepository);
	}
	
	@Test
	public void getRecipes() throws Exception{
		Recipe recipe = new Recipe();
		HashSet<Recipe>	recipesDate = new HashSet<Recipe>();
		recipesDate.add(recipe);
		
		when(recipeRepository.findAll()).thenReturn(recipesDate);
		
		Set<Recipe> recipes = recipeService.getRecipes();
		 
		assertEquals(recipes.size(),1);
		verify(recipeRepository,times(1)).findAll();
	}

}
