package com.newclass;

public class A implements Cloneable {
	
	public  A(){
		System.out.println("ram");
	}

	public static void main(String[] args) 
			throws CloneNotSupportedException {
		// TODO Auto-generated method stub
     A a=new A();
     A a1=(A)a.clone();
     
	}

}
