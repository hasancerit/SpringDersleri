package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import guru.springframework.services.GreetingService;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	@Qualifier("GetterGreetingService")
    private GreetingService greetingService;
	
	public String sayHello() {
		System.out.println("Hello Controller 2");
		return greetingService.sayGreeting();
	}
}
