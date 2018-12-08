package com.jichun.dao;

import com.jichun.domain.Employees;

public interface EmpDao {
	
	public void save(Employees emp);

	public Employees getEmp(String ID);
}
