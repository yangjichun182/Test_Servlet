package com.jichun.dao;

import com.jichun.domain.Student;

public interface StudentDao {
	
	public void save(Student student);

	public Student getStudent(String ID);
}
