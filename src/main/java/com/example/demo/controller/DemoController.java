/*package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.CalcDate;
import com.example.demo.mapper.CalcDateRepository;

@Controller
public class DemoController {
	
	@Autowired
	CalcDateRepository calcDateMapper;
	
	@RequestMapping("/")
	public String index(Model model) {
	List<CalcDate> list = calcDateMapper.selectAll();
	model.addAttribute("calcDate",list);
	return "index";
	}
}*/
