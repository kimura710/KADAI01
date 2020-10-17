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
	
	// �T�[�r�X�N���X��DI
	@Autowired
	private CalculationService service;
	
	// �����\������
	@GetMapping
	public String index(@ModelAttribute SimulationForm form) {
		return "simulation";
	}
	// BindingResult���g�������͒l�̌���
	// �G���[�̏ꍇ�̓��^�[������
	@PostMapping
	public String simulation(@ModelAttribute @Validated SimulationForm form,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "simulation";
		}
		//�@�C���X�^���X������1������BaseDate�A��Q������search�������
		SimulationForm sf = new SimulationForm(form.getBaseDate(),service.search());
		List<Result> results = sf.getResults();
		
		results.stream().forEach(e -> e.setCalculated(service.calclate(form.getBaseDate(), e.getCalc())));
		model.addAttribute("results",results);
		return "simulation";
	}
	//�@�C�ӂ̓��t���폜����
	@PostMapping(value="/{detaId}")
	public String delete(@PathVariable String dateId,Model model) {
		service.delete(dateId);
		model.addAttribute("simulationForm",new SimulationForm());
		return "simulation";
	}
	

}
