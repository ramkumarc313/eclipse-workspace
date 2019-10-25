package com.javacollector;

public class iterfaceacct   {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demo d=new demoImplement();
		d.show();
	}

	
}


interface demo
{
	public void show();
}

interface demo2
{
	public void show();

	
}
class demoImplement implements demo
{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("ram");
	}
	
}