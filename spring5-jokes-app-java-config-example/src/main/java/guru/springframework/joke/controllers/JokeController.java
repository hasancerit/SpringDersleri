package guru.springframework.joke.controllers;

import guru.springframework.joke.config.DenemeBean;
import guru.springframework.joke.services.JokeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 5/25/17.
 */
@Controller
public class JokeController {
    private JokeService jokeService;
    
    @Autowired
    private DenemeBean denemeBean1; 
    
    @Autowired
    private ApplicationContext ctx;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model){
    	System.out.println("Controller İçindeki:"+denemeBean1.getD());
        model.addAttribute("joke", jokeService.getJoke());
        return "chucknorris";
    }
}
