package com.collection;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class listcollection {

	private static final int String = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> al=new ArrayList<String>();
		al.add("ram");
		al.add("kumar");
		al.add("be");
		al.add("be");
		al.forEach(names ->System.out.println(names));
		
		Set<String> set=new HashSet<String>();
		set.add("ram");
		set.add("kumar");
		set.add("be");
		set.forEach(names->System.out.println("set"+names));
		
		Map<String,String> map=new HashMap();
		map.put("1","ram");
		map.put("2","kumar");
		map.put("3","kumar");
		map.put("4",null);
		


	}

}
