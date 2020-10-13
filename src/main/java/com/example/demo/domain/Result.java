package com.example.demo.domain;

import java.util.Arrays;
import java.util.StringJoiner;

public class Result {
	
	private CalcDate calc;
	
	private String calculated;

	public CalcDate getCalc() {
		return calc;
	}

	public void setCalc(CalcDate calc) {
		this.calc = calc;
	}
	public String getDateId() {
		return calc.getDateId();
	}
	public String getDateName() {
		return calc.getDateName();
	}

	public String getCalculated() {
		return calculated;
	}

	public void setCalculated(String calculated) {
		this.calculated = calculated;
	}
	public String getYmd() {
		int[] ymd = {calc.getValueYear(),calc.getValueMonth(),calc.getValueDay()};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(ymd).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}

}
