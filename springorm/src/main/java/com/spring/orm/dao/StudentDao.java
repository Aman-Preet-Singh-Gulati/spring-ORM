package com.spring.orm.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional	
	public int insert(Student student)
	{
		// Inserting the new data
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
		
	}
	
	// Extracting single object
	public Student getStudent(int studentId)
	{
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	
	// Get all students object
	public List<Student> getAllStudents()
	{
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
	
	// Deleting student
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	// Updating student
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
