package com.rail.core;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Station {
	
	private long id;
	private int phoneCode;
	private String name;
	private String managedBy;
	 
	public Station() {
		super();
	}
	public Station(long id, int phoneCode, String name, String managedBy) {
		super();
		this.id = id;
		this.phoneCode = phoneCode;
		this.name = name;
		this.managedBy = managedBy;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(int phoneCode) {
		this.phoneCode = phoneCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagedBy() {
		return managedBy;
	}
	public void setManagedBy(String managedBy) {
		this.managedBy = managedBy;
	}
	@Override
	public String toString() {
		return "Station [id=" + id + ", phoneCode=" + phoneCode + ", name=" + name + ", managedBy=" + managedBy + "]";
	}
	 
	 
}
