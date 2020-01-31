package com.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.health.PlanProperties;

//TODO
//TODO
public class HomeController {
	@Autowired private PlanProperties planProperties;	
 
	//TODO
	public String index(@Value("${app.subTitle}") String str, Model model) {
	   model.addAttribute("subTitle",str);
 	   model.addAttribute("types", planProperties);
	   return "home";
	}
}
