package com.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entities.Employee;
import com.springjdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {

		String query = "insert into student(id,name) values(?,?)";
		int i = this.jdbcTemplate.update(query, student.getId(), student.getName());

		return i;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int update(Student student) {
		String query = "update student set name=? where id=? ";
		int update = this.jdbcTemplate.update(query, student.getName(), student.getId());

		return update;
	}

	@Override
	public int delete(int id) {
		String query = "delete from student where id=?";
		int update = this.jdbcTemplate.update(query, id);

		return update;
	}

	@Override
	public void create(Employee emp) {
		String query = "create table employee(id int primary key , name varchar(50))";
		this.jdbcTemplate.execute(query);
		System.out.println("table created ");
	}

	RowMapper <Student> row = new RowMapperImpl();

	@Override
	public Student fetch(int id) {
		
		String query="Select * from student where id =?";
		Student student = this.jdbcTemplate.queryForObject(query, row, id );

		return student;
	}

	@Override
	public List<Student> fetchAll() {
		
		String query="Select * from student";
		List<Student> query2 = this.jdbcTemplate.query(query, row);
		return query2;
	}

}
