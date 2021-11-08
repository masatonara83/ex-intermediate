package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.Ex01Service;

@Controller
@RequestMapping("/team")
public class Ex01Controller {

	@Autowired
	private Ex01Service service;
	
	@RequestMapping("/list")
	public String showList(Model model) {
		List<Team> teamList = service.showList();
		model.addAttribute("teamList", teamList);
		
		return "/team/list";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		Team team = service.showDetail(id);
		
		model.addAttribute("team", team);
		
		
		System.out.println(team);
		
		return "/team/detail";
	}
}
