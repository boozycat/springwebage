package com.health.service;

 
import java.util.List;

import com.health.core.HealthPlan;

public interface HealthPlanDAO {
 
	public List<HealthPlan> getPlans();
	public HealthPlan getPlan(long id);
	public void add(HealthPlan plan); 

}
