package com.hardik.vacationplanner.model;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;

import com.hardik.vacationplanner.model.Destination.DestinatinType;

@Name("factories")
public class Factories {
	
	@Factory
	public DestinatinType[] getDestinationTypes() {
		return DestinatinType.values();
	}
}
