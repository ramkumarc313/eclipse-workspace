package com.mkyong.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
         List<String> items=
        Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");
         
         Map<String,Long> map=items
        		 .stream()
        		 .collect(
        		Collectors.groupingBy(
        				Function.identity(),Collectors.counting()
        				)
        				 );
         
        
         System.out.println(map);
         
         Map<String, Long> finalMap = new LinkedHashMap<>();

         //Sort a map and add to finalMap
         map.entrySet().stream()
                 .sorted(Map.Entry.<String, Long>comparingByValue()
                         .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

         System.out.println(finalMap);

        		 
	}

}
