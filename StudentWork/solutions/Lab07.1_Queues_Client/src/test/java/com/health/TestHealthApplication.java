package com.health;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.health.core.HealthPlan;

public class TestHealthApplication {
	
	private final String URL = "http://localhost:8082/insure/healthPlan/domestic";
	
  
	@Test
	public void testPost() throws JSONException { 
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
		HealthPlan plan = new HealthPlan();
		plan.setCopay(30.00);
		plan.setDeductableFamily(3000);
		plan.setDeductableIndividual(2500);
		plan.setName("HMO");
		plan.setZip(77777);
		plan.setOutOfPocketFamily(5500);
		plan.setOutOfPocketIndividual(5000);
		HttpEntity<HealthPlan> entity = new HttpEntity<HealthPlan>(plan, headers);
		ResponseEntity<String> response = 
				new RestTemplate().exchange(URL, HttpMethod.POST, entity,String.class);
		System.out.println(response); 
	}
 
}
