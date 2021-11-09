package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelServise;

@Controller
@RequestMapping("hotel")
public class HotelController {

	@Autowired
	private HotelServise servise;
	
	@RequestMapping("input")
	public String input() {
		return "hotel/input";
	}
	
	@RequestMapping("/result")
	public String toresult(Integer price, Model model) {
		
		if(price == null || price >= 0 && price <= 300000) {
			List<Hotel> hotelList = servise.findByPrice(price);
			model.addAttribute("price", price);
			model.addAttribute("hotelList", hotelList);
		} else {
			model.addAttribute("error", "値が正しくありません");
		}
		return "/hotel/input";
	}
}
