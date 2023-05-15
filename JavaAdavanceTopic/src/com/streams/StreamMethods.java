package com.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {

	public static void main(String[] args) {
		
		
		 // filter(predicate)
		//boolean value function // e -> e>10
		
//		 List<Object> name = List.of("Aman","Amit","Saras","pradeep","Kite");
//			Stream<Object> stream = name.stream();
//			List<Object> collect = name.stream().filter(e-> ((String) e).startsWith("A")).collect(Collectors.toList());
			
//			collect.forEach(e ->System.out.println(e));
//		 second way
				 
//	name.stream().filter(e -> ((String) e).startsWith("A")).forEach(i -> System.out.println(i));
			
		
		// map ( function)
//		each element operation
	List<Integer> number = List.of(2,3,5,7,9);

	
	List<Integer> newNumbers =number.stream().map(i -> i*i).collect(Collectors.toList());
	System.out.println(newNumbers);
	
//	number.stream().forEach(e -> System.out.println(e) );
//	number.stream().forEach(System.out::println);
	
	// sorted
	number.stream().sorted().forEach(System.out::println);
	
	// min and max
	Integer integer = number.stream().min((x,y) -> x.compareTo(y)).get();
	System.out.println(integer);
	
	
	
	}
}
