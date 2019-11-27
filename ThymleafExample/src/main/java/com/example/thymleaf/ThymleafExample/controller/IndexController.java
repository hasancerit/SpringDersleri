package com.example.thymleaf.ThymleafExample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
		
	@GetMapping("/{id}")
	public String getIndex(@PathVariable String id,Model model) {
		if(id.equalsIgnoreCase("1")) {
			model.addAttribute("isim","Hasan");
			model.addAttribute("isAdmin",true);
		}else {
			model.addAttribute("isim","Misafir");
			model.addAttribute("isAdmin",false);
		}
		return "index";
		
	}
	
	@ResponseBody
	@GetMapping("/getdatarp")
	public String getDataReqParam(@RequestParam String id) {
		return id;
	}
	
	@ResponseBody
	@GetMapping("/getdatama")
	public String getDataModelAttribute(@RequestParam String id) {
		return id;
	}
}
