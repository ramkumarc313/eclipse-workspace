package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConcurrentModificationExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			//System.out.println("List Value:" + value);
			if (value.equals("3"))
			{
				myList.remove(value);
			}
		}

		
		

	}




}
