package com.collection;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class concurrenthashmapex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentHashMap<String, String> ch=new ConcurrentHashMap();
		ch.put("ram", "kumar");
		
		for(Entry<String, String> em:ch.entrySet())
		{
			ch.put("sri", "kumar");
		}

	}

}
