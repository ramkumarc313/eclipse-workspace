package com.work;

public class CrunchifyStringToCharArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testString = "This Is Test";
        char [] toChar=testString.toCharArray();
		System.out.print(toChar);

		for (char output : toChar) {
			System.out.print(output);
		}

	}

}
