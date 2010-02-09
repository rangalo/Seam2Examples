package com.hardik.seamcalculator;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import javax.ejb.Stateless;

@Stateless
@Name("calcAction")
public class CalcAction implements Calc {

    @In
    @Out
    private Calculator calculator;
    
	
	public String calculate() {
		calculator.add();
        return "";
	}

}
