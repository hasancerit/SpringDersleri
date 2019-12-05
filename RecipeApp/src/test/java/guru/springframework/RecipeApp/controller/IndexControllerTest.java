package guru.springframework.RecipeApp.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import guru.springframework.RecipeApp.model.Recipe;
import guru.springframework.RecipeApp.services.RecipeService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;
/**
 * Created by jt on 6/17/17.
 */
public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() throws Exception {
    	
    	//Given
    	HashSet<Recipe> recipes = new HashSet<Recipe>();
    	recipes.add(new Recipe());
    	
    	Recipe recipe = new Recipe();
    	recipe.setId(1L);
    	recipes.add(recipe);
    	
    	when(recipeService.getRecipes()).thenReturn(recipes);
    	
    	@SuppressWarnings("unchecked")
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
    	
    	//When
        String viewName = controller.getIndex(model);

        //Then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }

}