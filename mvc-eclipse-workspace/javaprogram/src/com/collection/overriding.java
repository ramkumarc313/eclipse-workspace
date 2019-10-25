package com.collection;

public class overriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    student s=new student();
    s.method();
   // college c=new college();
   // c.method();
   // student m=new college();
   // m.method();
    
	}

	
}

class student{
	student()
	{
		System.out.println("parent class constructor");

	}
	
	public void method()
	{
		System.out.println("parent class");
	}
}

class college extends student{
	college()
	{
		System.out.println("over ride class constructor");

	}
	
	public void method()
	{
		System.out.println("over ride class");
	}
	
}