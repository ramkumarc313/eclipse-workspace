package com.collection;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
	
	public static void main(String args[]) {
		//System.out.println(10);
		  List<String> list_Strings = new ArrayList<String>();
		  list_Strings.add("Red");
		  list_Strings.add("Green");
		  list_Strings.add("Orange");
		  list_Strings.add("White");
		  list_Strings.add("Black");
		  // Print the list
		  System.out.println(list_Strings);
		  list_Strings.add(0, "blue");
		  list_Strings.add(5, "yellow");

		  System.out.println(list_Strings);

		
	}

}
