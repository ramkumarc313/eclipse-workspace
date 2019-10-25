package com.javacollector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class collectorExamble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<product> al=new ArrayList<product>();
		al.add(new product(1,"horlicks","pkg",15));
		al.add(new product(2,"boost","pkg",5));

		al.add(new product(11,"complan","bottle",10));

		al.add(new product(22,"biscut","pkg",20));

		al.add(new product(15,"rice","kg",80));

		al.add(new product(13,"womanhorlicks","bottle",15));

		al.add(new product(15,"horlicks","box",10));

		al.add(new product(16,"juniorhorlicks","pkg",8));
		
		List<String> set=al.stream().map(x ->x.itemname).collect(Collectors.toList());
		System.out.println(set);

		
	}
	
	

}

class product{
	int id;
	String itemname;
	String uom;
	int qty;
	product(int id,String itemname,String uom,int qty)
	{
		this.id=id;
		this.itemname=itemname;
		this.uom=uom;
		this.qty=qty;
	}
	
	
	
}