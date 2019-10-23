package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

public class EmployeeServiceImplment implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee inserEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
