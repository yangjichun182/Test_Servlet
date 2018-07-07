package com.pactera.dao;

import com.pactera.domain.Student;

public interface StudentDao {
	
	public void save(Student student);

	public Student getStudent(String ID);
}
