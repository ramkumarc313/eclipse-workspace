package com.stringprograms;

public class nontoStringclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student s=null;
		
		System.out.println(s);
		student s1=new student(1,"ram","30");
		System.out.println(s1);
		
		student s3=new student(2,"ram","30");
		System.out.println(s3);


	}


}

class student{
	int id;
	String name;
	String age;
	
	
	public student(int id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}