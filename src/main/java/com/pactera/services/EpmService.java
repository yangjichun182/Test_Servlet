package com.pactera.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.dao.EmpDao;
import com.pactera.domain.Employees;
import com.pactera.domain.Student;

@Service("empService")
public class EpmService {
	
	@Autowired(required=true)
	private EmpDao empDao;

	public void save(Employees emp) {
		empDao.save(emp);
	}

	public Employees getEmp(String id) {
		Employees emp = empDao.getEmp(id);
		return emp;
	}
}
