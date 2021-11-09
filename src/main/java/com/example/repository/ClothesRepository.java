package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Clothes;

@Repository
public class ClothesRepository {

	private static final RowMapper<Clothes> CLOTHES_ROW_MAPPAR = new BeanPropertyRowMapper<>(Clothes.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public List<Clothes> findByGenderAndColor(Integer gender, String color){
		
		
		String sql = "SELECT * FROM clothes WHERE gender = :gender AND color = :color ORDER BY price;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		
		List<Clothes> clothesList = template.query(sql, param, CLOTHES_ROW_MAPPAR);
		
		return clothesList;
	}
	
}
