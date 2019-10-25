package com.javacoparater;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapexamble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> hm=new HashMap<>();
		hm.put("ram", "kumar");
		hm.put("ravi", "krishnan");
		hm.put("muthu", "shankara");
		hm.put("hari", "haran");
		hm.put("siva", "arun");
		hm.put("yuva", "raj");
		hm.put("sri", "ram");
		
		
		
		List<Entry<String, String>> al=new LinkedList<Entry<String, String>>(hm.entrySet());
		
		Collections.sort(al,new Comparator<Entry<String, String>>()
				
				{

					@Override
					public int compare(Entry<String, String> o1, Entry<String, String> o2) {
						// TODO Auto-generated method stub
						return o1.getValue().compareTo(o2.getValue());
					}});
		
		Map<String, String> map=new LinkedHashMap<String, String>();
		for(Entry<String, String> mp:al) {
			
			map.put(mp.getKey(), mp.getValue());
		}
				
		for(Map.Entry<String, String> mp :map.entrySet()) {
			System.out.println(mp.getKey()+" "+mp.getValue());
			
		}

	}

}
