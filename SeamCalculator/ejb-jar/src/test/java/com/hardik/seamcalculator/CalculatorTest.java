package com.hardik.seamcalculator;

import org.testng.annotations.Test;

import com.hardik.seamcalculator.Calculator;

public class CalculatorTest {
	
	private double tollerance = 0.001;
	
	@Test
	public void testAdd() throws Exception {
		Calculator testCalculator = new Calculator();
		testCalculator.setValue1(10.0);
		testCalculator.add();
		testCalculator.setValue2(20.0);
		
		
		assert (testCalculator.getAnswer() - 30.0 < tollerance );
	}

	}
