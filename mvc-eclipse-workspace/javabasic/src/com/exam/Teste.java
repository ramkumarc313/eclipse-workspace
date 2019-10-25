package com.exam;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class foo{
            public int i = 3;
            //int b = Math.abs(-5);	
		}
        Object o = (Object)new foo();
        foo foo = (foo)o;
        System.out.println("i = " + foo.i);

	}

}
