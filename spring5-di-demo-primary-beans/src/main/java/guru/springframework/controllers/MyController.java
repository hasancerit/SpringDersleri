package guru.springframework.controllers;

import guru.springframework.services.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 5/23/17.
 */
@Controller
public class MyController {
	
	@Autowired
    private GreetingService greetingService;

    public String hello(){
        System.out.println("Hello Controller 1 ");

        return greetingService.sayGreeting();
    }
}
