package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SimulationForm {
	
	@NotBlank
	@Pattern(regexp = "((19|[2-9][0-9])[0-9{2])(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])")
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