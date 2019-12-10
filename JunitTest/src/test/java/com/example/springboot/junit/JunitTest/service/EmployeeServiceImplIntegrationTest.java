package com.example.springboot.junit.JunitTest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springboot.junit.JunitTest.model.Employee;
import com.example.springboot.junit.JunitTest.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {
	
	@Before
	public void setUp() {
	    Employee alex = new Employee("alex");
	 
	    Mockito.when(employeeRepository.findByName(alex.getName()))
	      .thenReturn(alex); 
	    //Sahte repoImp özelliklerini belirledik.
	    //employeeRepo'ya findByName istegi gelirse(Param olarak alex olan), alex nesnesini döndür
	}
 
    @TestConfiguration //Test Sınıfları icin özel conf classı
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }
 
    @Autowired
    private EmployeeService employeeService;
 
    @MockBean//Sahte bir repoImp olusturdu
    private EmployeeRepository employeeRepository;
 
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Employee found = employeeService.getEmployeeByName(name);
      
         assertThat(found.getName())
          .isEqualTo(name);
     }
}
