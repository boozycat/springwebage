package com.health.repository;

 
 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.health.core.HealthPlan;
@RepositoryRestResource(collectionResourceRel="plans", path ="options",
excerptProjection=Plan.class)  
public interface HealthPlanRepository extends PagingAndSortingRepository<HealthPlan, Long>{
	
	List<HealthPlan> findByZipAndName(int zip, String name);
	List<HealthPlan> findByNameAndCopayLessThan(String name, double copay);
	
	@Query("SELECT plan FROM HealthPlan plan WHERE (plan.name = :name AND plan.outOfPocketIndividual < :oop AND plan.deductableIndividual = :deductableInd) ")
	List<HealthPlan> finderNameOutOfPocketDeductable(@Param("name") String name, @Param("oop") int oop, @Param("deductableInd") int deductableInd);

 
	
} 
