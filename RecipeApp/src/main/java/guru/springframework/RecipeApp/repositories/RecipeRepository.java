package guru.springframework.RecipeApp.repositories;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.RecipeApp.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe,Long>{
	
}
