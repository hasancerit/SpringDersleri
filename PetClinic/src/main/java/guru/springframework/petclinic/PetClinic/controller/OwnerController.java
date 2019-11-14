package guru.springframework.petclinic.PetClinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.petclinic.PetClinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	
	@GetMapping({"","/","/index","/index.html"})
	public String listOwners(Model model) {
		model.addAttribute("owners",ownerService.findAll());
		return "owners/index";
	}
}
