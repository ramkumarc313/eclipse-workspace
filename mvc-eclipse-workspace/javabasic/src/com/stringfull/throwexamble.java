package com.stringfull;

public class throwexamble {

	public static void run() 
	{
		try
		
		{
			
			throw new ArithmeticException("sorry");  

		}
		finally
		{
			System.out.println("ram");
		}
	}

	public void show()
	{

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}

}
