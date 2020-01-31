package com.health.core;
 
import javax.xml.bind.annotation.XmlRootElement;
  @XmlRootElement(name="plan")
public class HealthPlan {
 
	private long id;
	private int zip;
	private String name;
	 
	private int  deductableIndividual;
	 
	private int  deductableFamily;
	 
	private int  outOfPocketIndividual;
	 
	private int  outOfPocketFamily;
	 
	private double copay;
	
	
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
	    

}
