package com.exam;

public class MyThread extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread s=new MyThread();
		s.start();
		System.out.println("kumar");
		//s.stop();
		//s.start();
		System.out.println("be");

	}
	
	public void run()
	{
		System.out.println("ram");
	}

}
