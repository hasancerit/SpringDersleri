package com.example.springboot.junit.JunitTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.junit.JunitTest.model.Employee;
import com.example.springboot.junit.JunitTest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	  
	@Autowired
	private EmployeeRepository employeeRepository;
	 
	@Override
	public Employee getEmployeeByName(String name) {
		System.out.println("Find By Name"+employeeRepository.getClass());
	      return employeeRepository.findByName(name);
	}
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl bean olustu");
	}

	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("Get All Employees");
		return employeeRepository.findAll();
	}

	@Override
	public String test() {
		return "Service ici test";
	}

	@Override
	public String deneme() {
		return "Service İci deneme";
	}
	
	public String ozelMetod() {
		return "Özel Metod";
	}
}
