package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRipository;

@Service
@Transactional
public class HotelServise {

	@Autowired
	private HotelRipository ripository;
	
	public List<Hotel> findByPrice(Integer price){

		return ripository.findByPrice(price);
	}
}
