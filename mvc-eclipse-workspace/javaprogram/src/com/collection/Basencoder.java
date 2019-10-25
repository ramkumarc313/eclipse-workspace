package com.collection;

import java.util.Base64;

public class Basencoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = "ramkumar";
		String s=encoder.encodeToString(normalString.getBytes());
		System.out.println(s);
		
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] s1=decoder.decode(s.toString());
		
		
		System.out.println(new String(s1));

 

	}

}
