package guru.springframework.petclinic.PetClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {
	
	@GetMapping({"/vets/index.html","/vets/index","/vets"})
	public String listVets(){
		return "vets/index";
	}
	
}
