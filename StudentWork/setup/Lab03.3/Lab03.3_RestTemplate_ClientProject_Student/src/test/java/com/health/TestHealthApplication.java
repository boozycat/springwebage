package com.health;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.health.core.HealthPlan;

public class TestHealthApplication {
	
	private final String URL = "http://localhost:8082/insure/healthPlan";
	
	@Test
	public void testGetForObject() throws JSONException {
		String response = new RestTemplate().getForObject(URL + "/{id}", String.class, 1);
		System.out.println(response);
		JSONObject obj = new JSONObject(response);
		System.out.println(obj.get("name"));
		System.out.println(obj.get("deductableFamily"));
	}
	@Test
	public void testGetForEntity() throws JSONException {
		ResponseEntity<String> response = new RestTemplate().getForEntity(URL + "/{id}", String.class, 1);
		System.out.println(response.getStatusCodeValue());
		JSONObject obj = new JSONObject(response.getBody());
		System.out.println(obj.get("name"));
		System.out.println(obj.get("deductableFamily"));
	}
 
	@Test
	public void testGetforType() throws JSONException {
		 //TODO
	}
	@Test
	public void testContentNegotiationXML() throws JSONException { 
		//TODO
	}
	@Test
	public void testContentNegotiationJSON() throws JSONException { 
		//TODO
	}
	@Test
	public void testContentNegotiationObject() throws JSONException { 
		//TODO
	}
	
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
		//TODO
	}
 
}
