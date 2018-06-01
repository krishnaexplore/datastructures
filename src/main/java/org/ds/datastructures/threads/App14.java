package org.ds.datastructures.threads;

/**
 * 
 * How to interrupt
 * */

import java.util.Random;

public class App14 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("starting..;  "+Thread.currentThread().getName());
		
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Random rand = new Random();
				
				
				for(int i = 0; i<1E8; i++) {
					/*try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("We have been interrupted");
						break;
					}*/
					
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted");
						break;
					}
					Math.sin(rand.nextDouble());
				}
				
				System.out.println("finished thread ; "+Thread.currentThread().getName());
				
			}
		});
		t1.start();
		
		Thread.sleep(500);
		
		t1.interrupt();
		
		t1.join();
		
		System.out.println("finished;;  "+Thread.currentThread().getName());
	}
}
