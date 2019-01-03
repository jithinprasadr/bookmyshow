package com.micro.authservice.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AppUser findByUsername(String username)
	{
		return jdbcTemplate.queryForObject("select * from app_user where username=?", new Object[] {username}, new BeanPropertyRowMapper<AppUser>(AppUser.class));
	}
}
