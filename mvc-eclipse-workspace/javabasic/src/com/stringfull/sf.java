package com.stringfull;

public class sf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sf=new StringBuffer("ram");
		sf.append("be");
		System.out.println(sf);
		sf.delete(1, 2);
		System.out.println(sf);
		sf.insert(1,"a");
		System.out.println(sf);
         sf.reverse();
 		System.out.println(sf);
 		
 		System.out.println(sf.capacity());


	}

}
