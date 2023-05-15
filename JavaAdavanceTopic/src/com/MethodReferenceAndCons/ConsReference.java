package com.MethodReferenceAndCons;

public class ConsReference {

	public static void main(String args[] ){
		
	
	
//	ConsInter cons = () ->{
//		return new Student();
//	};
// Second way using constructor reference
		ConsInter cons = Student::new;
		

	Student stu =cons.getStudent();
	stu.display();
	
	
	}
}
