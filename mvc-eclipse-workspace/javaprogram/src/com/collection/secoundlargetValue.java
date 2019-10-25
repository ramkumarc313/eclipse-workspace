package com.collection;

import java.util.ArrayList;
import java.util.List;

public class secoundlargetValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> al=new ArrayList<Integer>();
		al.add(55);
		al.add(4);

		al.add(56);//2

		al.add(1);

		al.add(88);//1

		al.add(39);

		al.add(10);
		
		
		int secoundValue=al.get(0);
		int largetvalue=al.get(0);
		for(int i=0;i<al.size();i++) {
			
			if(al.get(i)>largetvalue)
			{
				secoundValue=largetvalue;
				largetvalue=al.get(i);
			}
			if(al.get(i)>largetvalue && secoundValue !=largetvalue) {
				secoundValue=al.get(i);
			}
		}
		System.out.println(secoundValue);

      
	}

}
