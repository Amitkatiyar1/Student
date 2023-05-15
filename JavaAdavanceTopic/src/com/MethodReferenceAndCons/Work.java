package com.MethodReferenceAndCons;

public class Work {

	// overriding the iterface using passing the reference passing the same argument like overriding
		public static void dowork() {
			System.out.println("i am doing work");
		}

       public static void threadtask() {
    	   for(int i =0;i<10;i++) {
    		   System.out.println(i*2);
    		   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   }
       }

}
