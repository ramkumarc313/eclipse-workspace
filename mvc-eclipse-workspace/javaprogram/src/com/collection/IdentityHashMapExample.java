package com.collection;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map ihm=new IdentityHashMap();
		ihm.put("ram", "kumar");
		ihm.put("sri", "kumar");
		ihm.put("ram", "rajan");
		System.out.println(ihm);

		System.out.println(ihm.size());

		Map hm=new HashMap();
		hm.put("ram", "kumar");
		hm.put("sri", "kumar");
		hm.put("ram", "prabhu");
		System.out.println(hm);
		System.out.println(hm.size());


	}

}
