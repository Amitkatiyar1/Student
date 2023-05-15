package com.lambda;

public class ThreadA {

	public static void main(String[] args) {
		
		
		Runnable run =()->{
			for(int i=0; i<10;i++) {
			System.out.println("Runnning.............."+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
	Thread df = new Thread(run);
	df.setName("Amit");
	df.start();
	
	
	Runnable run1 =()->{
		for(int i=0; i<10;i++) {
		System.out.println("Runnning second.............."+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	};
Thread df1 = new Thread(run1);
df1.setName("Ami");
df1.start();
	}

}
