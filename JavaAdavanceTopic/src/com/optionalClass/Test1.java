package com.optionalClass;
@FunctionalInterface
interface Student{
	
	 void  fun(String name);
	 int age =6;
}
public class Test1 implements Student{

	public static void main(String[] args) {
	Test1 t = new Test1();
	t.fun("Amit");
	}

	@Override
	public void fun(String name) {
		System.out.println(name+age);
	}

}
