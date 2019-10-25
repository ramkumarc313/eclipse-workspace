package com.collection;

import java.util.Scanner;

public class inputmismatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double num;
		int max = 0;
		int min =0 ;
	    @SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
	    num = reader.nextDouble();                         
	    while (num < min || num > max) {                 
	        System.out.print("Invalid. Re-enter number: "); 
	        num = reader.nextDouble();                         
	    }

	}

}
