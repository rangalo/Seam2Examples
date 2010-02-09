package com.hardik.vacationplanner.action;

import javax.ejb.Local;

@Local
public interface VacationManager {
	public void beforeRender();
	public String selectVacationType() throws Exception;
	
	public void remove();
}
