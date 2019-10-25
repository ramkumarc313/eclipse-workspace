package com.exam;

public class MyOuter {
	public static class myinner{
        public static void foo() { }

	}
	public static void main(String[] args) {
		myinner o=new myinner();
		MyOuter.myinner m=new MyOuter.myinner();
		MyOuter.myinner m2=new myinner();
	
	}

}
