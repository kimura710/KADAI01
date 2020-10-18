package com.example.demo.controller;

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

import com.example.demo.domain.CalcDate;
import com.example.demo.domain.SimulationForm;
import com.example.demo.service.CalculationService;

// 日付計算式を更新する画面に紐づくコントローラー

@Controller
@RequestMapping("/update/{dateId}")
public class UpDateController {
	
	// サービスクラスをDI
	@Autowired
	private CalculationService service;
	
	//　初期表示処理
	@GetMapping
	public String index(@PathVariable String dateId,Model model) {
		model.addAttribute("calcDate",service.search(dateId));
		return "update";
	}
	// 日付計算式を更新する
	// 更新した後は一覧画面へ
	@PostMapping
	public String update(@ModelAttribute @Validated CalcDate calcDate,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "update";
		}
		service.update(calcDate);
		model.addAttribute("simulationForm",new SimulationForm());
		return "simulation";
	}

}
