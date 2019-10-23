package com.jackrutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackrutorial.dao.EmployeeDaoImpl;
import com.jackrutorial.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDaoImpl employeeDao;

	 
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findeEmployeeById(id);
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.addEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		employeeDao.deleteEmployee(id);
		
	}

}
