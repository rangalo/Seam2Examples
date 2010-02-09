package com.hardik.seamcalculator;

import javax.ejb.Local;

@Local
public interface Calc {
	
	public String calculate();
	
}
