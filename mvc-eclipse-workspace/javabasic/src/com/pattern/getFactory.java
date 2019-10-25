package com.pattern;

public class getFactory extends plan {

	public static void main(String args[])
	{
		getFactory p=new getFactory();
		p.mathod();
	}

	@Override
	void mathod() {
		// TODO Auto-generated method stub
		System.out.println("ramkumar");
	}

}
abstract class plan{

	abstract void mathod();


}

abstract class plan1 extends plan{

	abstract void mathod();


}
