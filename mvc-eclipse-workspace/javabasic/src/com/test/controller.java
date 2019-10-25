package com.test;

public class controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		employeeedao emp=new EmployeeImpl();
		
		emp.show(25);
		
		employeeedao dep=new DepartmentImp();
		dep.show();
		

	}

}
