package com.health.service;

 
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.health.core.HealthPlan;
@Component @Profile("test")
public class HealthPlanDAOMock implements HealthPlanDAO{
	 
	
	 
	public List<HealthPlan> getPlans(){
		List<HealthPlan> list = new ArrayList<>();
		list.add(new HealthPlan(99L, 12345, "HMO", 0, 0, 5000, 5000, 20.00));
		return list;
	}


	@Override
	public HealthPlan getPlan(long id) {
        return new HealthPlan(99L, 12345, "HMO", 0, 0, 5000, 5000, 20.00);
	}
	      

	@Override
	public void add(HealthPlan plan) {
		 
	}
	
	 

}
