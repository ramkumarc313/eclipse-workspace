package com.test;

public class MyThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread th=new Thread() {
			
			public void run()
			{
				System.out.println("ramkumar");
			}
		};
		th.start();
		
		System.out.println("finished");

	}

}
