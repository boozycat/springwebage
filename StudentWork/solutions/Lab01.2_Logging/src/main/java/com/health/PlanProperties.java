package com.health;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties("health")
@Validated
public class PlanProperties {
	@DecimalMax(value="60.00", message="Copays are too high as it is")
	private double maxCopay;
	@DecimalMin("30.00")
	private int maxDeductableIndividual;
	private List<PlanType> planTypes = new ArrayList<PlanType>();
	
	static class PlanType {
		@Size(max=7)
		private String symbol;
		@Size(min=4)
		private String name;
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	public double getMaxCopay() {
		return maxCopay;
	}

	public void setMaxCopay(double maxCopay) {
		this.maxCopay = maxCopay;
	}

	public int getMaxDeductableIndividual() {
		return maxDeductableIndividual;
	}

	public void setMaxDeductableIndividual(int maxDeductableIndividual) {
		this.maxDeductableIndividual = maxDeductableIndividual;
	}

	public List<PlanType> getPlanTypes() {
		return planTypes;
	}

	public void setPlanTypes(List<PlanType> planTypes) {
		this.planTypes = planTypes;
	}

}
