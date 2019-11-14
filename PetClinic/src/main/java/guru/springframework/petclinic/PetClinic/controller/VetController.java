package guru.springframework.petclinic.PetClinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import guru.springframework.petclinic.PetClinic.services.VetService;

@Controller
public class VetController {
	
	@Autowired
	VetService vetService;
	
	@GetMapping({"/vets/index.html","/vets/index","/vets"})
	public String listVets(Model model){
		model.addAttribute("vets",vetService.findAll());
		return "vets/index";
	}
	
}
