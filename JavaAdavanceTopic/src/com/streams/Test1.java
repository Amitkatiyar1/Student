package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(67);
		list.add(6);
		list.add(7);

		List<Integer> of = List.of(68, 3, 4, 678, 8, 87);

		List<Integer> asList = Arrays.asList(2, 3, 46, 8, 9, 0);

		Stream<Integer> stream = list.stream();
		List<Integer> list2 = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(list2);

		Stream<Integer> stream2 = asList.stream();
		List<Integer> collect = stream2.filter(e -> e % 2 == 0).collect(Collectors.toList());
		System.out.println(collect);

	}

}
