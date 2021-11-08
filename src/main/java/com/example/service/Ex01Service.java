package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.Ex01Repository;

@Service
@Transactional
public class Ex01Service {

	@Autowired
	private Ex01Repository ex01Repository;
	
	public List<Team> showList(){
		return ex01Repository.showList();
	}
	
	public Team showDetail(Integer id) {
		return ex01Repository.showDetail(id);
	}
	
}
