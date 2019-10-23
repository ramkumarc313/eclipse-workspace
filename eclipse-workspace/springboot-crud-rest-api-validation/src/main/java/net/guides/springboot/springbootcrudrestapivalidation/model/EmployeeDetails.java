package net.guides.springboot.springbootcrudrestapivalidation.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Employee_details")
public class EmployeeDetails {
	
	@NotNull
	private long id;
	
	@NotNull
	private long  employeeId;
	
	@NotNull
	@Size(min = 2, message = "qualification should have atleast 2 characters")
	private String qualification;	
	

	@NotNull
	private double salary;
	


	public EmployeeDetails() {
		
		// TODO Auto-generated constructor stub
	}

	@NotNull
	@Size(min = 2, message = "adress should have atleast 2 characters")
	private String adress;
	
	@NotNull
	@Size(min = 2, message = "state should have atleast 2 characters")
	private String state;
	
	@NotNull
	@Size(min = 2, message = "city should have atleast 2 characters")
	private String city;
	
	public EmployeeDetails(long employeeId,String qualification,double salary,String adress,String state,String city) {
		
		this.employeeId = employeeId;
		this.qualification = qualification;
		this.salary = salary;
		this.adress = adress;
		this.state = state;
		this.city = city;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="employee_Id",nullable=true)
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name="qualification",nullable=true)
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Column(name="salary",nullable=true)
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Column(name="adress",nullable=true)
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name="state",nullable=true)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="city",nullable=true)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
