package com.lambda;



public class Test3{
	public static void main(String[] args) {
		
//		MyInter my = new MyInterImple();
//		my.sayHello();
		
//		 Using ano class 
		
//		MyInter i = new MyInter() {
//
//			@Override
//			public void sayHello() {
//			System.out.println("I am Amit");
//				
//			}
//			
//		};
//		i.sayHello();
//		MyInter i2 = new MyInter() {
//
//			@Override
//			public void sayHello() {
//			System.out.println("I am Amit");
//				
//			}
//			
//		};
//		i2.sayHello();
		
//		using lambda Expression
		 
//		MyInter i = ()->{
//			System.out.println("I am Amit");
//		};
//		
//		i.sayHello();
		
		
//		MyInter i = (x ,y) -> x+y;
//		
//		System.out.println(i.Sum(2,4));
//		System.out.println(i.Sum(3,6));
//		
		
		
		
		MyInter i = (str)->str.length();
		
		System.out.println(i.getlength("Amit katiyar"));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}
