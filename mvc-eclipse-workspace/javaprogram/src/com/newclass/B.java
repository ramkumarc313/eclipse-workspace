package com.newclass;

public class B  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          c C=new E();
          C.show();
          Object i = Integer.valueOf(42);
         // String s = (String)i;            
         // System.out.println(s);
          stringimmutable sm=new stringimmutable();
          sm.function();
	}

	
	


}

interface c
{
	   int i=20;
	 public void show();
}

interface d
{
	  int i=10;
	 public void show();
}

class E implements c,d{

	@Override
	public void show() {
		
		// TODO Auto-generated method stub
		System.out.println();
	}
	
}