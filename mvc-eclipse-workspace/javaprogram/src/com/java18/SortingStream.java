package com.java18;

import java.util.Arrays;
import java.util.List;

public class SortingStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String>al=Arrays.asList("ram","4","kumar","arun","xevior","yowan","muthu","muthu");
		
		al.stream().sorted().forEach(System.out::println);
		System.out.println();
		al.stream().distinct().forEach(System.out::println);
		
		al.stream().distinct().forEach(p-> System.out.println(p) );

	}

}
