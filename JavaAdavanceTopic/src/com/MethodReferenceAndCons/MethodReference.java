package com.MethodReferenceAndCons;

public class MethodReference {

	public static void main(String[] args) {
		
		System.out.println("Learning Method refer");
		
		// Provide the implementation of workInter
//		WorkInter workin = ()->{
//		System.out.println("this is doWork");	
//			
//		};
//		workin.doTask();
		
// static method reference
		//className:: methodName
		// overriding the iterface using passing the reference passing the same argument like overriding
		WorkInter workin = Work::dowork;
		workin.doTask();
		
	// Thread reference
		Runnable running = Work::threadtask;
		
		Thread t = new Thread(running);
		t.start();
		
		
	}

}
