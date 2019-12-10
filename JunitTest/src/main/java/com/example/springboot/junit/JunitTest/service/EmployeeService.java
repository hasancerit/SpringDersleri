package com.example.springboot.junit.JunitTest.service;

import java.util.List;

import com.example.springboot.junit.JunitTest.model.Employee;

public interface EmployeeService {
	public Employee getEmployeeByName(String name);

	public List<Employee> getAllEmployees();
	
	public String test();
	
	public String deneme();

}
