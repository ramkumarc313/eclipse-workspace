package com.javabasics;

public class javatesting<T> {

	T obj;  
	void add(T obj){
		this.obj=obj;
	}  
	T get(){
		return obj;
	}  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javatesting a=new javatesting();
		a.add(33);
		System.out.println(a.get());

	}

}
