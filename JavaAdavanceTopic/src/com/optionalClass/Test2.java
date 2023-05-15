package com.optionalClass;

interface Animal1{
	default void dog() {
		System.out.println("running.........");
	}
}
@FunctionalInterface
interface Birds1 extends Animal1{
	
	void crow(String name);
}

public class Test2 implements Birds1 {

	public static void main(String[] args) {
		Test2 tr = new Test2();
		tr.crow("flying............");
		tr.dog();
		
	}

	

	@Override
	public void crow(String name) {
		System.out.println(name);
	}

}
