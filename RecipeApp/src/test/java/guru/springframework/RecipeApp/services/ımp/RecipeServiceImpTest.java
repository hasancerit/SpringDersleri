	package guru.springframework.RecipeApp.services.ımp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;  
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
	
	 @Test
	    public void getRecipeByIdTest() throws Exception {
	        Recipe recipe = new Recipe();
	        recipe.setId(1L);
	        Optional<Recipe> recipeOptional = Optional.of(recipe);

	        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

	        Recipe recipeReturned = recipeService.findById(1L);

	        assertNotNull("Null recipe returned", recipeReturned);
	        verify(recipeRepository, times(1)).findById(anyLong());
	        verify(recipeRepository, never()).findAll();
	    }

}
