package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Result;
import com.example.demo.domain.SimulationForm;
import com.example.demo.service.CalculationService;

@Controller
@RequestMapping
public class SimulationController {
	
	// サービスクラスをDI
	@Autowired
	private CalculationService service;
	
	// 初期表示処理
	@GetMapping
	public String index(@ModelAttribute SimulationForm form) {
		return "simulation";
	}
	// BindingResultを使った入力値の検証
	// エラーの場合はリターンする
	@PostMapping
	public String simulation(@ModelAttribute @Validated SimulationForm form,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "simulation";
		}
		//　インスタンス化し第1引数にBaseDate、第２引数にsearchをいれる
		SimulationForm sf = new SimulationForm(form.getBaseDate(),service.search());
		List<Result> results = sf.getResults();
		
		results.stream().forEach(e -> e.setCalculated(service.calclate(form.getBaseDate(), e.getCalc())));
		model.addAttribute("results",results);
		return "simulation";
	}
	//　任意の日付を削除する
	@PostMapping(value="/{detaId}")
	public String delete(@PathVariable String dateId,Model model) {
		service.delete(dateId);
		model.addAttribute("simulationForm",new SimulationForm());
		return "simulation";
	}
	

}
