package com.hardik.seamcalculator;

import org.jboss.seam.annotations.Name;
import org.hibernate.validator.Max;
import org.hibernate.validator.Min;
import org.hibernate.validator.Range;



/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Jan 29, 2010
 * Time: 9:06:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Name("calculator")
public class Calculator {

    private double value1;
    private double value2;
    private double answer;

    @Min(value = 0)
    @Max(value = 100)
    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    @Range(min = 0, max = 100)
    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public void add() {
        this.answer = this.value1 + this.value2;
    }
}
