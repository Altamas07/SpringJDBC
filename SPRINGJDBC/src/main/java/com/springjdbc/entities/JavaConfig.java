package com.springjdbc.entities;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImpl;

@Configuration
public class JavaConfig {

	@Bean("data")
	public DataSource getDataSource() {
		
		DriverManagerDataSource dm=new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dm.setUsername("root");
		dm.setPassword("root");
		
		return dm;
	
	}
	@Bean("jdbctemplate")
	public JdbcTemplate getTemplate() {
		
		JdbcTemplate jdbc=new JdbcTemplate();
		jdbc.setDataSource(getDataSource());
		
		return jdbc;
	}
	@Bean("st")
	public StudentDao getDao() {
		
		StudentDaoImpl st=new StudentDaoImpl();
		st.setJdbcTemplate(getTemplate());
		return st;
		
	}
}
