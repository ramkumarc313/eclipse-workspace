package com.javacodegeeks.example;


public class Employee {
	
	private Long id;

	private String firstname;

	private String lastname;

	private Department department;

	public Employee() {
	}

	public Employee(String firstname, String lastname) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}



}
