package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

@Repository
public class HotelRipository {

	private static final RowMapper<Hotel> HOTEL_ROW_MAPPAR = new BeanPropertyRowMapper<>(Hotel.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public List<Hotel> findByPrice(Integer price){
		
		if(price == null) {
			String selectSql = "SELECT * FROM hotels ORDER BY price;";
			
			List<Hotel> hotelLists = template.query(selectSql, HOTEL_ROW_MAPPAR);
			
			return hotelLists;
		} 
		
		String sql = "SELECT * FROM hotels WHERE price <= :price ORDER BY price;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPAR);
		
		return hotelList;
	}
}
