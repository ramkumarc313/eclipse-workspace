package com.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class hashmapvaluesorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer,String> hm=new HashMap<Integer,String>();
		hm.put(1, "ram");
		hm.put(10, "kumar");
		hm.put(30, "arun");
		hm.put(13, "brabha");
		hm.put(12, "subha");
		hm.put(19, "sabha");
		hm.put(17, "sadha");
		hm.put(18, "radha");
		hm.put(11, "vedha");
		List<Entry<Integer, String>> t = hm.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());

				t.forEach(System.out::println);

				


	}

}
