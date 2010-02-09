package com.hardik.vacationplanner.action;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import com.hardik.vacationplanner.model.Destination;
import com.hardik.vacationplanner.model.Destination.DestinatinType;

@Stateful
@Name("vacationManagerAction")
public class VactionManagerAction implements VacationManager {
	
	@In
	Destination destination;

	@Logger
	private Log logger;
	
	@Override
	public void beforeRender() {
		logger.info("Just about to render the page");
		
	}

	@Override
	@Remove
	@Destroy
	public void remove() {
	}

	@Override
	public String selectVacationType() throws Exception {
		DestinatinType dType = destination.getDestinationType();
		if (null == dType) {
			throw new Exception("Null value:");
		}
		logger.debug("DestinationType:",dType);
		if (dType.equals(DestinatinType.ACTION)) {
			return "danger";
		} else if (dType.equals(DestinatinType.BEACH)) {
			return "beach";
		} else if (dType.equals(DestinatinType.CITY)) {
			return "city";
		} else {
			throw new Exception("Oops");
		}
	}

}
