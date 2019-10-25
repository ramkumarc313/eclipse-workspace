package com.java18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl","abcd");
		//List<String> filtered =strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
       // System.out.println(filtered);
        
        
		List<String> filtered1 =strings.stream().filter(string -> string.equals("abcd")).collect(Collectors.toList());
        System.out.println(filtered1);

	}

}
