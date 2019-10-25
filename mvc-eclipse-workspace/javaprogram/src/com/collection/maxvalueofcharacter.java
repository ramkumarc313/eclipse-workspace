package com.collection;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class maxvalueofcharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s=Stream.of("T","R","A","C","Z","Y","S").max(Comparator.comparing(String::valueOf)).get();
		System.out.println(s);
		String min=Stream.of("T","R","A","C","Z","Y","S").min(Comparator.comparing(String::valueOf)).get();
		//String missn=Stream.of("T","R","A","C","Z","Y","S")

		System.out.println(min);


	}

}
