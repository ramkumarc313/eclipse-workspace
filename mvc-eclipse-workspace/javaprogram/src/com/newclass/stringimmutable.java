package com.newclass;

public class stringimmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="222";
		s="444";
		String r="4455";
		s.concat(r);
		System.out.println(s);
		sss ss=new sss();
		ss.function();
	}

	protected void function() {

		System.out.println("ram");
	}

}

class sss
{
	protected void function() {

		System.out.println("ram");
	}
}