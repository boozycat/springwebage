package com.health.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.health.core.HealthPlan;

@Projection(name="plan", types=HealthPlan.class)
public interface Plan {
	long getId(); 
	String getName();

    @Value("#{target.outOfPocketFamily - target.outOfPocketIndividual}")
    int getDifferential();


}
