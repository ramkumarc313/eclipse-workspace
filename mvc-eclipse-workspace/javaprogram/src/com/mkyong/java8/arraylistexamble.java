package com.mkyong.java8;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class arraylistexamble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al=new ArrayList<>();
		al.add("ram");
		al.add("ram");
		al.add("ram");
		al.add("ram");
		al.add("ram");
		
	Collector<Object, ?, Map<Object, Long>> list=Collectors.groupingBy(Function.identity(),Collectors.counting());
		System.out.println(list);

	}

}
