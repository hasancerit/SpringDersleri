package com.example.thymleaf.ThymleafExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

@SpringBootApplication
public class ThymleafExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymleafExampleApplication.class, args);
	}

}
