package pmk.learnjava8withrealapps.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p1", "mobile 1", 1000, 2, "Manufacturer 1"));
		products.add(new Product("p2", "mobile 2", 700, 4, "Manufacturer 1"));
		products.add(new Product("p3", "laptop 1", 1200, 6, "Manufacturer 2"));
		products.add(new Product("p4", "laptop 2", 7000, 9, "Manufacturer 2"));
		products.add(new Product("p5", "laptop 3", 2300, 7, "Manufacturer 2"));
		
		//products.stream().sorted((p1,p2) -> (long) p1.getPrice().compareTo(p2.getPrice())).forEach(System.out::println);
		List<Product> p1=products.stream().sorted(Comparator.comparing(p ->p.getPrice())).collect(Collectors.toList());
	
		p1.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getPrice()));
		System.out.println("         ");
		List<Product> p2=products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.toList());
		p2.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getPrice()));

	}

}
