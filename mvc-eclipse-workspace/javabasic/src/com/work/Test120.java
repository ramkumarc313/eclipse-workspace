package com.work;

public class Test120 extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    s1 s=new s1();
	    s.start();
	    Test120 t=new Test120();
	    t.start();
		

	}
	public void run() {
		for(int i=0;i<3;i++) {
			System.out.print("C");
			System.out.println("D");

		}
	}

}

class s1 extends Thread
{
	
	public void run() {
		for(int i=0;i<3;i++) {
			System.out.print("A");
			System.out.println("B");

		}
	}
	
}