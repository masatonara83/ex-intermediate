package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Clothes;
import com.example.repository.ClothesRepository;

@Service
@Transactional
public class ClothesServise {

	@Autowired
	private ClothesRepository repository;
	
	public List<Clothes> findByGenderAndColor(Integer gender, String color) {
		return repository.findByGenderAndColor(gender, color);
	}
}
