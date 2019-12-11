package com.example.springboot.junit.JunitTest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.jsf.FacesContextUtils;

import com.example.springboot.junit.JunitTest.model.Employee;
import com.example.springboot.junit.JunitTest.repository.EmployeeRepository;
import com.example.springboot.junit.JunitTest.utils.Factory;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {

    @Autowired
    private EmployeeService employeeService;
 
    @MockBean//Sahte bir EmployeeRepositoryImp olusturdu
    private EmployeeRepository employeeRepository;
    
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
 
 
/*	
	@MockBean
	EmployeeServiceImpl employeeService;
	
	@MockBean
	Factory factory;
	
	@Before
	public void setUp() {
	    Mockito.when(employeeService.test())
	      .thenReturn("Test ici test"); 
	    
	    Mockito.when(employeeService.deneme())
	    	.thenReturn("Test İci Deneme");
	    	    
	    Mockito.when(employeeService.getEmployeeByName("Alex")).thenReturn(new Employee("Alex"));
	}
	
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
    	System.out.println("Sonuc1:"+employeeService.test());
    	System.out.println("Sonuc2:"+employeeService.deneme());
    	
    	Employee sonuc3 = employeeService.getEmployeeByName("Alex");
    	 assertThat(sonuc3.getName())
         .isEqualTo("Alex");
    	 
    	 System.out.println("Sonuc4:"+employeeService.ozelMetod());
    	 System.out.println("Sonuc5:"+factory.factoryMethod());
     }
     */
}
