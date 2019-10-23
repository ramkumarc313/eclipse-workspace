package com.demo.model;

import javax.persistence.*;

@Entity
@Table(name="Employee")

public class Employee {
	
	public Employee(String empName, int empAge, String qualification, String mobileNo) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.qualification = qualification;
		this.mobileNo = mobileNo;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_age")
	private int empAge;
	
	@Column(name="emp_degree")
	private String qualification;
	
	@Column(name="emp_mobile",nullable=false)
	private String mobileNo;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String empName, int empAge, String qualification, String mobileNo) {
		super();
		this.id = id;
		this.empName = empName;
		this.empAge = empAge;
		this.qualification = qualification;
		this.mobileNo = mobileNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empAge=" + empAge + ", qualification=" + qualification
				+ ", mobileNo=" + mobileNo + "]";
	}
	

}
