package com.jackrutorial.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jackrutorial.model.Employee;
import com.jackrutorial.model.EmployeeRowMapper;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		  String query = "SELECT * from employees";
          RowMapper<Employee>  rm=new EmployeeRowMapper();
          List<Employee> al=jdbcTemplate.query(query, rm);
		return al;
	}

	@Override
	public Employee findeEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		  String query = "SELECT * FROM employees WHERE employee_id = ?";
		  
		  RowMapper<Employee> rm=new BeanPropertyRowMapper<Employee>(Employee.class);
		  Employee employee = jdbcTemplate.queryForObject(query, rm, id);

		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		  String query = "INSERT INTO employees(employee_id, first_name, last_name, email, phone, job_title) VALUES(?, ?, ?, ?, ?, ?)";
		  jdbcTemplate.update(query, employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhone(), employee.getJobTitle());
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		  String query = "UPDATE employees SET first_name=?, last_name=?, email=?, phone=?, job_title=? WHERE employee_id=?";
		  jdbcTemplate.update(query, employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhone(), employee.getJobTitle(), employee.getEmployeeId());
		  

	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		  String query = "DELETE FROM employees WHERE employee_id=?";
		  jdbcTemplate.update(query, id);

		
	}

}
