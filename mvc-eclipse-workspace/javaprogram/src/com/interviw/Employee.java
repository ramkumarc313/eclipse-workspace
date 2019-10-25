package com.interviw;

public class Employee {

	private String name1;
	
	private String name2;

	
	
	
	@Override
	public String toString() {
		return (name1 + name1);
	}

	public String toString1() {
		return (name1 .concat (name1));
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		Employee emp1=null;

		System.out.println(emp);
		System.out.println(emp1);


	}

}
