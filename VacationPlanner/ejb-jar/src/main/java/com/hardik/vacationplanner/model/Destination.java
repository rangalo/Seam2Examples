package com.hardik.vacationplanner.model;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.jboss.seam.annotations.Name;

@Name("destination")
public class Destination implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public enum DestinatinType {
		ACTION("Action"), BEACH("Beach"), CITY("City");
		
		private String label;
		
		private DestinatinType(String label) {
			this.label = label;
		}
		
		public String getLabel() {
			return this.label;
		}
	}
	
	private double minimumBudget;
	
	@Enumerated(EnumType.STRING)
	private DestinatinType destinationType;


	public double getMinimumBudget() {
		return minimumBudget;
	}


	public void setMinimumBudget(double minimumBudget) {
		this.minimumBudget = minimumBudget;
	}


	public DestinatinType getDestinationType() {
		return destinationType;
	}


	public void setDestinationType(DestinatinType destinationType) {
		this.destinationType = destinationType;
	}
	
	

}
