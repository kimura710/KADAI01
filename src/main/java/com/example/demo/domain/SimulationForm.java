package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SimulationForm {
	
	@NotBlank
	@Pattern(regexp = "yyyyMMdd")
	private String baseDate;
	
	private List<Result> results;
	
	public SimulationForm() {
		
	}
	public SimulationForm(String baseDate,List<CalcDate> results) {
		this.baseDate = baseDate;
		this.results = new ArrayList<>();
		results.stream().forEach(r -> this.results.add(convertToResult(r)));
	}
	public String getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}
	public List<Result> getResults(){
		return results;
	}
	public Result convertToResult(CalcDate calc) {
		return new Result(calc);
		
	}
	
	

}