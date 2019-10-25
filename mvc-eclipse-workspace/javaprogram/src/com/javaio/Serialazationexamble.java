package com.javaio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialazationexamble {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Student st=new Student(1,"ram","20");
		//st.toString();
		String filenae="C:\\Users\\Developer\\Desktop\\ram.text";
		// System.out.println(st.toString());
        FileOutputStream file = new FileOutputStream(filenae); 
        ObjectOutputStream out = new ObjectOutputStream(file); 


	 out.writeObject(st); 
    
  out.close(); 
  file.close(); 
    
  System.out.println("Object has been serialized"); 

} 

}

class Student implements Serializable {
	int id;
	String name;
	String age;
	
	public Student(int id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	
	
}
