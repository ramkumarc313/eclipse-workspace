package com.codereusabalidy;

public class TestInheritance3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          dog d=new dog() ;
         // d.eat();
          animal a=new dog();
          a.eat();
          
	}

}

class animal{
	
	void eat()
	{
		System.out.println("animal");
	}
	
}
class dog extends animal{
	
	void eat()
	{
		
		System.out.println("foot");
	}
	
}
class cat extends animal {
	void eat()
	{
		System.out.println("meat");
	}
}