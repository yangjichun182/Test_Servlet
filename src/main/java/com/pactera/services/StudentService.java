package com.pactera.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.dao.StudentDao;
import com.pactera.domain.Student;

@Service("studentService")
public class StudentService {
	
	@Autowired(required=true)
	private StudentDao studentDao;

	public void save(Student student) {
		studentDao.save(student);
	}

	public Student getStudent(String id) {
		Student student = studentDao.getStudent(id);
		return student;
	}
}
