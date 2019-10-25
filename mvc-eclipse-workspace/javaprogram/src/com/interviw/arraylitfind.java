package com.interviw;

import java.util.ArrayList;

public class arraylitfind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<String> bags = new ArrayList<String>(); 
        bags.add("pen"); 
        bags.add("paper"); 
        bags.add("books"); 
        bags.add("rubber"); 
        bags.add("pen"); 
        bags.add("paper"); 
        bags.add("books"); 
        bags.add("rubber"); 
        System.out.println(bags.size());
        int count=0;
        for(String s:bags) {
        	count++;
        	if(count==5)
        	{
        		System.out.println(s);
        	}
        	if(s.length()==5) {
        	//	System.out.println(s);

        	}
        }
        System.out.println(count);
       
	}

}
