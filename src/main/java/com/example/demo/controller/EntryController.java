package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.CalcDate;
import com.example.demo.domain.SimulationForm;
import com.example.demo.service.CalculationService;

@Controller
@RequestMapping("/entry")
public class EntryController {
	
	// 日付計算サービスをDI
	@Autowired
	public CalculationService service;
	
	//　初期表示処理
	@GetMapping
	public String index(@ModelAttribute CalcDate form) {
		return "entry";
	}
	// 日付計算式を新規登録
	// 登録した後は一覧画面に戻るようになっている
	@PostMapping
	public String entry(@ModelAttribute @Validated CalcDate form,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "entry";
		}
		service.entry(form);
		model.addAttribute("simulationForm",new SimulationForm());
		return "simulation";
	}

}
