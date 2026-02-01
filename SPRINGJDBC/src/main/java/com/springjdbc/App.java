package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Employee;
import com.springjdbc.entities.JavaConfig;
import com.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("project started !");

		ApplicationContext app = new AnnotationConfigApplicationContext(JavaConfig.class);

		/*
		 * StudentDao bean = app.getBean("st",StudentDao.class); Student student=new
		 * Student(); student.setId(1232); student.setName("Hashim"); int insert =
		 * bean.insert(student); System.out.println("inserted successfully"+insert);
		 * 
		 * StudentDao dao = app.getBean("st",StudentDao.class); Student student2=new
		 * Student(); student2.setId(1232); student2.setName("aamir");
		 * 
		 * 
		 * int update = dao.update(student2); System.out.println(update);
		 */
		/*
		 * StudentDao dao1 = app.getBean("st", StudentDao.class); Student s = new
		 * Student(); s.setId(129); int delete = dao1.delete(120);
		 * System.out.println(delete);
		 * 
		 * StudentDao d1 = app.getBean("st",StudentDao.class); Employee emp=new
		 * Employee(); d1.create(emp);
		 */	  
		
		/*
		 * StudentDao bean = app.getBean("st", StudentDao.class);
		 * 
		 * Student st = new Student();
		 * 
		 * Student fetch = bean.fetch(13); System.out.println(fetch);
		 */
		
		 StudentDao bean = app.getBean("st", StudentDao.class);
		  
		  Student st = new Student(); 
		  
		 List <Student> fetch = bean.fetchAll();
		 
		 for(Student s:fetch) {
			 
			 System.out.println(s);
		 }
		 
	}
}
