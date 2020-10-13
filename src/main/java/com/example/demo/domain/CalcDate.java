package com.example.demo.domain;

import javax.validation.constraints.NotBlank;


public class CalcDate {
	
	@NotBlank
	private String dateId;
	
	@NotBlank
	private String dateName;
	
	private int valueYear;
	
	private int valueMonth;
	
	private int valueDay;
	
	public String getDateId() {
		return dateId;
	}
	public void setDateId(String dateId) {
		this.dateId = dateId;
	}
	public String getDateName() {
		return dateName;
	}
	public void setDateName(String dateName) {
		this.dateName = dateName;
	}
	public int getValueYear() {
		return valueYear;
	}
	public void setValueYear(int valueYear) {
		this.valueYear = valueYear;
	}
	public int getValueMonth() {
		return valueMonth;
	}
	public void setValueMonth(int valueMonth) {
		this.valueMonth = valueMonth;
	}
	public int getValueDay() {
		return valueDay;
	}
	public void setValueDay(int valueDay) {
		this.valueDay = valueDay;
	}

}
