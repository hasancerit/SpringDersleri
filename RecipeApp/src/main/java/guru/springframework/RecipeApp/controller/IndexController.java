package guru.springframework.RecipeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import guru.springframework.RecipeApp.services.RecipeService;

@Controller
public class IndexController{
	private RecipeService recipeService;

	@Autowired
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping({"","/","/index","/index.html"})
	public String getIndex(Model model) {
		model.addAttribute("recipes",recipeService.getRecipes());
		return "index";
	}
}
