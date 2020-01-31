package com.health.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Agent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AGENTID")
	private long id;
	private String name;
	private String city;
	private String phone;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="PLANID")
	private HealthPlan healthPlan;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	 
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public HealthPlan getHealthPlan() {
		return healthPlan;
	}
	public void setHealthPlan(HealthPlan healthPlan) {
		this.healthPlan = healthPlan;
	}
	
	

}
