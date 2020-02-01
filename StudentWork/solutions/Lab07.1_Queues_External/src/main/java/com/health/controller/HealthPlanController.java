package com.health.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.health.core.HealthPlan;
import com.health.repository.HealthPlanRepository;

@RestController
@RequestMapping("/healthPlan")
public class HealthPlanController {
 
 
	@Autowired private HealthPlanRepository repo;
	
	@GetMapping(path="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public HealthPlan get(@PathVariable("id") long id) {
  	   return repo.findById(id).get();
	}
	@GetMapping(path="/entity/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<HealthPlan> getEntity(@PathVariable("id") long id) {
  	   BodyBuilder builder =  ResponseEntity.ok();
  	   builder.header("TotalPlans","Total Plans " + ((Collection<HealthPlan>) repo.findAll()).stream().count());
  	   return builder.body(repo.findById(id).get());
	}
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public List<HealthPlan> getAll(@RequestParam("code") Optional<String> optional) {
		String type = optional.orElse("HMO");
	    return ((Collection<HealthPlan>) repo.findAll()).stream().filter(p-> p.getName().equalsIgnoreCase(type)).collect(Collectors.toList());
	}
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> add(@RequestBody HealthPlan plan) throws URISyntaxException {
		HealthPlan pl = repo.save(plan);	 	 
		return ResponseEntity
				.created(new URI("healthPlan/"+pl.getId())).body( 
						 ((Collection<HealthPlan>) repo.findAll())
						.stream()
						.filter(p-> p.getName().equals(plan.getName()))
						.count());			
	}
	/*
	 * JMS Service
	 */
	@Autowired
	private JmsTemplate jmsTemplate;
	private static Logger logger = Logger.getLogger("HealthPlanController");
	@PostMapping(path="/domestic", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> addToQueue(@RequestBody HealthPlan plan)  {
		logger.log(Level.INFO, "Received message");
		jmsTemplate.convertAndSend("myQueue", plan);  
		logger.log(Level.INFO, "Sent message");
		return ResponseEntity.ok().build();		 	
	}
	
	
	
	
	


}
