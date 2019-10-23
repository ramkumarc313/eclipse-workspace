package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("emp")
	public ResponseEntity<List<Employee>> getEmployee()
	{
		System.out.println(employeeService.getEmployee());
		return ResponseEntity.ok(employeeService.getEmployee());
	}
	

	@GetMapping("emp")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee emp )
	{
		
		return ResponseEntity.ok(employeeService.inserEmployee(emp));
	}
	
	

}
