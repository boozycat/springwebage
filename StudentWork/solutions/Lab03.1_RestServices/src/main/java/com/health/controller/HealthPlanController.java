package com.health.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.health.core.HealthPlan;
import com.health.service.HealthPlanDAO;

@RestController
@RequestMapping("/healthPlan")
public class HealthPlanController {
	@Autowired private HealthPlanDAO dao;
	@GetMapping(path="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public HealthPlan get(@PathVariable("id") long id) {
  	   return dao.getPlan(id);
	}
	@GetMapping(path="/entity/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<HealthPlan> getEntity(@PathVariable("id") long id) {
  	   BodyBuilder builder =  ResponseEntity.ok();
  	   builder.header("TotalPlans","Total Plans " + dao.getPlans().stream().count());
  	   return builder.body(dao.getPlan(id));
	}
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public List<HealthPlan> getAll(@RequestParam("code") Optional<String> optional) {
		String type = optional.orElse("HMO");
	    return dao.getPlans().stream().filter(p-> p.getName().equalsIgnoreCase(type)).collect(Collectors.toList());
	}

}
