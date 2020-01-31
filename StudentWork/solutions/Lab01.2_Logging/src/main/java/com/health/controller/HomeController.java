package com.health.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.health.PlanProperties;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired private PlanProperties planProperties;	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
 
	@GetMapping
	public String index(@Value("${app.subTitle}") String str, Model model) {
	   model.addAttribute("subTitle",str);
 	   model.addAttribute("types", planProperties);
 	   logger.error("This is an error message");
 	   logger.warn("This is a warning message");
 	   logger.info("This is an info message");
	   return "home";
	}
}
