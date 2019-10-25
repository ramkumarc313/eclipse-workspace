package com.collection;

import java.util.HashMap;

public class Foreachmethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		hm.put(1, "ram");
		hm.put(10, "kumar");
		hm.put(30, "arun");
		hm.put(13, "brabha");
		hm.put(12, "subha");
		hm.put(19, "sabha");
		hm.put(17, "sadha");
		hm.put(18, "radha");
		hm.put(11, "vedha");
		hm.forEach((key,Value) ->System.out.println(key+","+Value));
		

	}

}
