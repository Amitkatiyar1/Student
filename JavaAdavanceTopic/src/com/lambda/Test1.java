package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
interface Student{
	
	void fun(int x);
}
public class Test1 implements Student{

	public static void main(String[] args) {
		
		
		 List <Integer>la =new ArrayList<Integer>();
		 la.add(6);
		 la.add(8);
		 la.forEach(e-> System.out.println(e*2)
		 );
       Student ty = (int x) -> System.out.println(2*x);
		 
		 ty.fun(45);
	}

	@Override
	public void fun(int x) {
		System.out.println(x);
		
	}

}
