package com.emp.curd.service;

import java.util.List;

import com.emp.curd.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee getById(int theId);

	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
