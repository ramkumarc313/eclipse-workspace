package com.java18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Groupbyclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<employee> al=new ArrayList<employee>();
		al.add(new employee(1,"ramkumar",30,"BE"));
		al.add(new employee(2,"sriram",27,"MCA"));
		al.add(new employee(5,"dharsan",2,"1st"));
		al.add(new employee(7,"surya",30,"BCA"));
		al.add(new employee(6,"arun",30,"MD"));
		al.add(new employee(3,"kumar",30,"BDA"));
		al.add(new employee(4,"ramkumar",30,"ME"));
		
		Map<String,List<employee>> map=al.stream().collect(Collectors.groupingBy(employee::getName));
	//	List<employee> al2=new ArrayList<employee>((Collection<? extends employee>) map.values());
		for(Map.Entry<String,List<employee>> s:map.entrySet())
		{
		//System.out.println(s.getKey()+" "+s.getValue());
		}
		//count
		
		Long count=al.stream().filter(e ->e.age>=30).count();
		System.out.println(count);
		
		// set list
		
		
		Set<String> set=al.stream().map(e ->e.name).collect(Collectors.toSet());
		System.out.println(set);
		
		
		// map
		
		
		Map<Integer,String> mapvalue=al.stream().collect(Collectors.toMap(e ->e.id, e ->e.name));
		
		System.out.println(mapvalue);

	}

}

class employee
{
	int id;
	String name;
	int age;
	String qualification;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public employee(int id, String name, int age, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", age=" + age + ", qualification=" + qualification + "]";
	}
	}