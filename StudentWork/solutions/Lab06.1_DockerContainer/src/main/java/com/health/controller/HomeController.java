package com.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.health.PlanProperties;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired private PlanProperties planProperties;	
	 
	@GetMapping
	public String index(@Value("${app.subTitle}") String str, Model model) {
	   model.addAttribute("subTitle",str);
 	   model.addAttribute("types", planProperties);
	   return "home";
	}
}
