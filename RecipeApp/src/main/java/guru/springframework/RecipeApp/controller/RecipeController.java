package guru.springframework.RecipeApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.RecipeApp.commands.RecipeCommand;
import guru.springframework.RecipeApp.repositories.RecipeRepository;
import guru.springframework.RecipeApp.services.RecipeService;

/**
 * Created by jt on 6/19/17.
 */
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }
    
    @GetMapping("/recipe/new")
    public String newRecipe(Model model){
    	model.addAttribute("recipe",new RecipeCommand());
    	
    	return "recipe/recipeform";
    }
    
    @GetMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
    	model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));
    	
    	return "recipe/recipeform";
    }
    
    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand){
    	RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);
    	return "redirect:/recipe/"+savedCommand.getId()+"/show/";
    }
    
    @GetMapping("/recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id){
    	recipeService.deleteById(Long.valueOf(id));
    	return "redirect:/";
    }
}