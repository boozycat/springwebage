package com.health.repository;

 
 
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.health.core.Agent;
@RepositoryRestResource(collectionResourceRel="agents", path ="agent") 
public interface AgentRepository extends PagingAndSortingRepository<Agent, Long>{
	 
	
} 
