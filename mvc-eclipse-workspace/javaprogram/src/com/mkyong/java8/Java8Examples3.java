package com.mkyong.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8Examples3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Item> imems=Arrays.asList(
				new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
					);
		Map<BigDecimal, Long> map=imems.stream().collect(Collectors.groupingBy(Item::getPrice,Collectors.counting()));
		
		System.out.println(map);
		imems.stream().sorted((p1,p2) -> p1.getPrice().compareTo(p2.getPrice())).forEach(System.out::print);
		

	}

}
