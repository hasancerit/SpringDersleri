package com.example.springboot.junit.JunitTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.junit.JunitTest.model.Employee;
import com.example.springboot.junit.JunitTest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
 
    @Autowired
    private EmployeeService employeeService;
 
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}