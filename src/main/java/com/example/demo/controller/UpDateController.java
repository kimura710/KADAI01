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

// ���t�v�Z�����X�V�����ʂɕR�Â��R���g���[���[

@Controller
@RequestMapping("/update/{dateId}")
public class UpDateController {
	
	// �T�[�r�X�N���X��DI
	@Autowired
	private CalculationService service;
	
	//�@�����\������
	@GetMapping
	public String index(@PathVariable String dateId,Model model) {
		model.addAttribute("calcDate",service.search(dateId));
		return "update";
	}
	// ���t�v�Z�����X�V����
	// �X�V������͈ꗗ��ʂ�
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
