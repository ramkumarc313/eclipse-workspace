package com.work;

public class X {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			System.out.println("c.");

			show();
			System.out.println("kumar");

		}
		catch(Exception ex) {
			System.out.println("rr");

		}
		finally
		{
			System.out.println("test");
		}
        System.out.print("BE"); 

	}

	public static void show()
	{
		System.out.println("ram");
		throw new Error();

	}
}
