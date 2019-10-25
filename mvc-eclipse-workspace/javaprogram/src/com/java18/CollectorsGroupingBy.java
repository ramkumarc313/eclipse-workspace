package com.java18;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsGroupingBy {
	public static void main(String[] args) {
		
		
        Student s1 = new Student("Ram", "A", 20);
        Student s2 = new Student("Shyam", "B", 22);
        Student s3 = new Student("Mohan", "A", 22);
        Student s4 = new Student("Mahesh", "C", 20);
        Student s5 = new Student("Krishna", "B", 21);
        List<Student> list = Arrays.asList(s1,s2,s3,s4,s5);

        Map<String,List<Student>>  map=list.stream().collect(Collectors.groupingBy(Student::getClassName));
        
        map.forEach((k,v) ->System.out.println("key:"+k+" "+
        		((List<Student>)v).stream().map(m ->m.getName()).collect(Collectors.joining(","))));
		
        
      Map<Integer, List<Student>> sortage=list.stream().collect(Collectors.groupingBy(Student::getAge));
      
      
      sortage.forEach((k,v) -> System.out.println("key"+k+" "+((List<Student>)v).stream().map(m ->m.getAge()).collect(Collectors.toList())));
	}

		

}


class Student {
    private String name;
    private int age;
    private String className;
    public Student(String name,String className,int age){
        this.name=name;
        this.age=age;
        this.className = className;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getClassName() {
        return className;
    }
} 