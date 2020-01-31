package com.health.core;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="PLAN")
@XmlRootElement(name="plan")
public class HealthPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PLANID")	
	private long id;
	private int zip;
	private String name;
	@Column(name="DEDUCTABLEIND")
	private int  deductableIndividual;
	@Column(name="DEDUCTABLEFAMILY")
	private int  deductableFamily;
	@Column(name="OUTOFPOCKETIND")
	private int  outOfPocketIndividual;
	@Column(name="OUTOFPOCKETFAMILY")
	private int  outOfPocketFamily;
	@Column(name="COPAY")
	private double copay;
	@JsonBackReference
	@OneToMany(mappedBy = "healthPlan", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<Agent> agents = new ArrayList<Agent>();
 
 
	public HealthPlan() {
		super();
	}
	public HealthPlan(long id, int zip, String name, int deductableIndividual,
			int deductableFamily, int outOfPocketIndividual,
			int outOfPocketFamily, double copay) {
		super();
		this.id = id;
		this.zip = zip;
		this.name = name;
		this.deductableIndividual = deductableIndividual;
		this.deductableFamily = deductableFamily;
		this.outOfPocketIndividual = outOfPocketIndividual;
		this.outOfPocketFamily = outOfPocketFamily;
		this.copay = copay;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeductableIndividual() {
		return deductableIndividual;
	}
	public void setDeductableIndividual(int deductableIndividual) {
		this.deductableIndividual = deductableIndividual;
	}
	public int getDeductableFamily() {
		return deductableFamily;
	}
	public void setDeductableFamily(int deductableFamily) {
		this.deductableFamily = deductableFamily;
	}
	public int getOutOfPocketIndividual() {
		return outOfPocketIndividual;
	}
	public void setOutOfPocketIndividual(int outOfPocketIndividual) {
		this.outOfPocketIndividual = outOfPocketIndividual;
	}
	public int getOutOfPocketFamily() {
		return outOfPocketFamily;
	}
	public void setOutOfPocketFamily(int outOfPocketFamily) {
		this.outOfPocketFamily = outOfPocketFamily;
	}
	public double getCopay() {
		return copay;
	}
	public void setCopay(double copay) {
		this.copay = copay;
	}
	@Override
	public String toString() {
		return "HealthPlan [id=" + id + ", zip=" + zip + ", name=" + name
				+ ", deductableIndividual=" + deductableIndividual
				+ ", deductableFamily=" + deductableFamily
				+ ", outOfPocketIndividual=" + outOfPocketIndividual
				+ ", outOfPocketFamily=" + outOfPocketFamily + ", copay="
				+ copay + "]";
	}
	public Collection<Agent> getAgents() {
		return agents;
	}
	public void setAgents(Collection<Agent> agents) {
		this.agents = agents;
	}
	    

}
