package com.health.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.health.PlanProperties;
import com.health.core.HealthPlan;
import com.health.service.HealthPlanDAO;

@Controller
@RequestMapping("/plan")
public class HealthController {
	@Autowired private PlanProperties planProperties;	 
	@Autowired private HealthPlanDAO dao;
	
	@ModelAttribute("subTitle")
	private String getDefaultTitle(Model model, @Value("${app.subTitle}") String str) {
		model.addAttribute("types", planProperties);
		return str;
	}
	 
	@GetMapping
	public String getPlans(@RequestParam("code") Optional<String> optional, Model model) {
	   String type = optional.orElse("HMO");
	   List<HealthPlan> plans = dao.getPlans().stream()
			   .filter(p-> p.getName().equalsIgnoreCase(type))
			   .filter(p-> p.getDeductableIndividual() <= planProperties.getMaxDeductableIndividual()) 
			   .filter(p-> p.getCopay() <= planProperties.getMaxCopay()).collect(Collectors.toList());
	   model.addAttribute("plans", plans);
	   return "search";
	}
	@GetMapping("/{id}")
	public String getIndividualplan(@PathVariable("id") long id, Model model) {
	   model.addAttribute("plan", dao.getPlan(id));
	   return "plan";
	}
}
