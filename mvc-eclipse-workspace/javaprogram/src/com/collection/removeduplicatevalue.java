package com.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class removeduplicatevalue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Map<String, String> map = new HashMap<>();
	    map.put("A", "1");
	    map.put("B", "2");
	    map.put("C", "2");
	    map.put("D", "3");
	    map.put("E", "3");
	    System.out.println("Initial Map : " + map);
	    for (String s : new HashMap<>(map).keySet()) {
	        String value = map.get(s);
	        for (Map.Entry<String, String> ss : new HashMap<>(map)
	                .entrySet()) {
	            if (s != ss.getKey() && value == ss.getValue()) {
	                map.remove(ss.getKey());
	            }
	        }
	    }
	    System.out.println("Final Map : " + map);


	}
	

}
