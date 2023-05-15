package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {

	public static void main(String[] args) {
//		Stream Api - collection process
//		Collection / group of object
//		 String name1[] = {"Amit","katiyar","pradeep","Saras"};
//
//		 Stream<Object> empty = Stream.empty();
//		 empty.forEach(e ->{
//			 System.out.println(e);
//		 });
//		 
//		 String name[] = {"Amit","katiyar","pradeep","Saras"};
//		
//		 Stream<String> stream = Stream.of(name);
//		 
//		 stream.forEach(e-> {
//			 System.out.println(e);
//		 });
	  IntStream stream2 = Arrays.stream(new int[] {1,2,3,5,6,7});
	  
		stream2.forEach(e ->{
			
		System.out.println(e)
		;}); 
		
		// most important collections using Stream
		
		List<Integer> list = new ArrayList<>();
		list.add( 75);
		list.add(67);
		Stream stream = list.stream();
		stream.forEach(e ->System.out.println(e));
	}

}
