package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entities.Employee;
import com.springjdbc.entities.Student;

public interface StudentDao {

	public int insert(Student student);
	public int update(Student student);
	public int delete(int id);
	public void create(Employee emp);
	public Student fetch(int id);
	public List <Student> fetchAll();
	
	
}
