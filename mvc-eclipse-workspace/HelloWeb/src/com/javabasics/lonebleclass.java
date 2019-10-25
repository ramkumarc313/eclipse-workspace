package com.javabasics;


public class lonebleclass implements Cloneable {

	
	int id;
	String name;
	
	public lonebleclass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + "]";
	}
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		lonebleclass s1=new lonebleclass(2,"ram");
		System.out.println(s1);
		lonebleclass s2=(lonebleclass)s1.clone();
		System.out.println(s2);


	}

}

class student 
{
	
	
}