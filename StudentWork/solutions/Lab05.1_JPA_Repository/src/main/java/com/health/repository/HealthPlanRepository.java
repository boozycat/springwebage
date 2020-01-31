package com.health.repository;

 
 
import java.util.List;

 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.health.core.HealthPlan;
  
 public interface HealthPlanRepository extends PagingAndSortingRepository<HealthPlan, Long>{
	
	public List<HealthPlan> findByZipAndName(int zip, String name);
	public List<HealthPlan> findByNameAndCopayLessThan(String name, double copay);
	
	@Query("SELECT plan FROM HealthPlan plan WHERE (plan.name = :name AND plan.outOfPocketIndividual < :oop AND plan.deductableIndividual = :deductableInd) ")
	public List<HealthPlan> finderNameOutOfPocketDeductable(@Param("name") String name, @Param("oop") int oop, @Param("deductableInd") int deductableInd);

 
	
} 
