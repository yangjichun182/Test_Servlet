package com.pactera.dao;

import com.pactera.domain.Employees;

public interface EmpDao {
	
	public void save(Employees emp);

	public Employees getEmp(String ID);
}
