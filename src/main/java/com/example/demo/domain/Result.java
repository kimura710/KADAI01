package com.example.demo.domain;

import java.util.Arrays;
import java.util.StringJoiner;

public class Result {
	
	private CalcDate calcDate;
	
	private String calculated;


	public Result(CalcDate calcDate) {
		this.calcDate = calcDate;
	}

	public CalcDate getCalcDate() {
		return calcDate;
	}

	public void setCalcDate(CalcDate calc) {
		this.calcDate = calc;
	}
	public String getDateId() {
		return calcDate.getDateId();
	}
	public String getDateName() {
		return calcDate.getDateName();
	}

	public String getCalculated() {
		return calculated;
	}

	public void setCalculated(String calculated) {
		this.calculated = calculated;
	}
	public String getYmd() {
		int[] ymd = {calcDate.getValueYear(),calcDate.getValueMonth(),calcDate.getValueDay()};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(ymd).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}

}
