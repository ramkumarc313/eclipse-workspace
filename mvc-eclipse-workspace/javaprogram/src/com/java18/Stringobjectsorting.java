package com.java18;

import java.util.ArrayList;
import java.util.List;

public class Stringobjectsorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<point> al=new ArrayList<>();
		al.add(new point(1,56));
		al.add(new point(21,4));
		al.add(new point(15,4));
		al.add(new point(31,7));
		al.add(new point(13,9));
		
		al.stream().sorted((p1,p2) ->p1.x.compareTo(p2.x)).forEach(System.out::println);


	}

}

class point
{
	Integer x,y;
	point(Integer a,Integer b){
		this.x=a;
		this.y=b;
	}
	
    public String toString() {  
		return this.x+","+this.y;
	}
}