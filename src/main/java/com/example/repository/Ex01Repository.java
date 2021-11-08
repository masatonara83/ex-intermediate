package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * teamsテーブルを操作するrepository
 * 
 * @author naramasato
 *
 */
@Repository
public class Ex01Repository {

	private static final RowMapper<Team> TEAM_ROW_MAPPER = new BeanPropertyRowMapper<>(Team.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 全件検索
	 * 
	 * @return　teamList(検索結果)
	 */
	public List<Team> showList(){
		String sql = "SELECT * FROM teams ORDER BY inauguration;";
		
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		
		return teamList;
		
	}
	
	/**
	 * 主キーから検索を行う
	 * 
	 * @param id
	 * @return 　team　(検索結果)
	 */
	public Team showDetail(Integer id) {
		
		String sql = "SELECT * FORM teams WHERE id = :id;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		
		return team;
	}
}
