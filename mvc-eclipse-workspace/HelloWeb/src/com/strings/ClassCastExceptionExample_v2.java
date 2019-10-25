package com.strings;

public class ClassCastExceptionExample_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p=new Parent();
		Child c=new Child();
		//c=p;
        Object obj = new Integer(100);
        System.out.println((String) obj);


	}

}


class Parent {
    public Parent() {
        System.out.println("An instance of the Parent class was created!");
    }
}
 
final class Child extends Parent {
    public Child() {
        super();
        System.out.println("An instance of the Child class was created!");
    }
}
