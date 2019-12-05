package guru.springframework.RecipeApp.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void getId() throws Exception{
		category.setId(4l);
		assertEquals(4l,category.getId());
	}
	
	@Test
	public void getDescription() throws Exception{
		
	}
	
	@Test
	public void getRecipes() throws Exception{
		
	}
}
