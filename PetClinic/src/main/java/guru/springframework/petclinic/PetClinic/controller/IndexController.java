package guru.springframework.petclinic.PetClinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import guru.springframework.petclinic.PetClinic.services.OwnerService;

@Controller
public class IndexController {
	@Autowired
	OwnerService ownerService;
	
	@GetMapping({"/index.html","/index","/",""})
	public String index(){
		System.out.println("List:"+ownerService.findAll().toString());
		return "index";
	}
	
	@GetMapping("/oups")
	public String oupsHandler() {
		return "notimplemented";
	}
}
