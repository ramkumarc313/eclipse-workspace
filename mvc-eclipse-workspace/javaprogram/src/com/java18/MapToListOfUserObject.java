package com.java18;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToListOfUserObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new HashMap<>();
		map.put(23, "Mahesh");
		map.put(10, "Suresh");
		map.put(26, "Dinesh");
		map.put(11, "Kamlesh");
		
		List<Person> al=map.entrySet().stream().sorted(Comparator.comparing(p -> p.getValue()))
				.map(p -> new Person(p.getKey(), p.getValue())).collect(Collectors.toList());
		al.forEach(l -> System.out.println("Id: "+ l.getId()+", Name: "+ l.getName()));		


	}

}

class Person {
	private Integer id;
	private String name;
	public Person(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
} 