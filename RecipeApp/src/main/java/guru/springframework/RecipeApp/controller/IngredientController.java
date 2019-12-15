package guru.springframework.RecipeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import guru.springframework.RecipeApp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IngredientController {
	private final RecipeService recipeService;

	@Autowired
	public IngredientController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping("/recipe/{recipeId}/ingredients")
	public String listIngredient(@PathVariable(name = "recipeId") String id,Model model){
		model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(Long.valueOf(id))));
		
		return "recipe/ingredient/list";
	}

}
