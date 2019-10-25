package com.comparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;

import com.tutorialspoint.Student;

public class comparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> al=new ArrayList<Student>();  
		al.add(new Student(101,"Vijay",23));  
		al.add(new Student(106,"Ajay",27));  
		al.add(new Student(105,"Jai",21));  
		al.add(new Student(102,"ram",21));  

		Collections.sort(al,new nameComparator());
		System.out.println(al);
		
		

	}

}

class nameComparator implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		int i=o1.getName().compareTo(o2.getName());
		return i;
	}
	
}