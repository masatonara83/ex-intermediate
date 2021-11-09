package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Clothes;
import com.example.service.ClothesServise;

@Controller
@RequestMapping("clothes")
public class ClothesController {

	@Autowired
	private ClothesServise servise;
	
	@RequestMapping("input")
	public String input() {
		
		return "/clothes/input";
		
		
	}
	
	@RequestMapping("result")
	public String toResult(Integer gender, String color, Model model) {
		List<Clothes> clothesList = servise.findByGenderAndColor(gender, color);
		
		if(clothesList != null) {
			model.addAttribute("clothesList",clothesList);
		}else {
			model.addAttribute("non","一件もありませんでした");
		}
		
		return "/clothes/input";
	}
}
