package guru.springframework.RecipeApp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.RecipeApp.model.UnitOfMeasure;

@Repository
public interface UnitOfMeausureRepository extends CrudRepository<UnitOfMeasure,Long>{
	Optional<UnitOfMeasure> findByDescription(String description);
}
