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
	public void testGetForResponseEntity() throws JSONException {
		ResponseEntity<HealthPlan> response = new RestTemplate().getForEntity(URL + "/entity/{id}", HealthPlan.class, 1);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
	}
	@Test
	public void testGetforType() throws JSONException {
		ResponseEntity<String> response1 = new RestTemplate().getForEntity(URL + "?code={id}", String.class, "HMO");
		System.out.println(response1); 
		ResponseEntity<List<HealthPlan>> response2 = 
				new RestTemplate().exchange(URL + "?code={id}", HttpMethod.GET, null, new ParameterizedTypeReference<List<HealthPlan>>() {
		}, "HMO");
		response2.getBody().forEach(System.out::println);
	}
	@Test
	public void testContentNegotiationXML() throws JSONException { 
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", MediaType.APPLICATION_XML_VALUE);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = 
				new RestTemplate().exchange(URL + "/{id}", HttpMethod.GET, entity,String.class, 2);
		System.out.println(response.getBody()); 
	}
	@Test
	public void testContentNegotiationJSON() throws JSONException { 
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = 
				new RestTemplate().exchange(URL + "/{id}", HttpMethod.GET, entity,String.class, 2);
		System.out.println(response.getBody()); 
	}
	@Test
	public void testContentNegotiationObject() throws JSONException { 
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<HealthPlan> response = 
				new RestTemplate().exchange(URL + "/{id}", HttpMethod.GET, entity,HealthPlan.class, 2);
		System.out.println(response.getBody()); 
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
		HttpEntity<HealthPlan> entity = new HttpEntity<HealthPlan>(plan, headers);
		ResponseEntity<String> response = 
				new RestTemplate().exchange(URL, HttpMethod.POST, entity,String.class);
		System.out.println(response); 
	}
 
}
