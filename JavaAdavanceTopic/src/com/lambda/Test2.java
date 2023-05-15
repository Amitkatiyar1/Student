package com.lambda;

public class Test2 {

	interface student{
		int add(int x,int y);
	}
	
	
	
	public static void main(String[] args) {
		
		student yu = (int x,int y) -> (x+y);
		student t = (x,y) ->(x*y);
		
	
		System.out.println(yu.add(56, 97));
		System.out.println(yu);
		

	}


	

	

}
