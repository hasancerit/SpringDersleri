package guru.springframework.RecipeApp.services;

import java.util.Set;

import guru.springframework.RecipeApp.commands.IngredientCommand;
import guru.springframework.RecipeApp.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

	Set<UnitOfMeasureCommand> listAllUoms();


}
