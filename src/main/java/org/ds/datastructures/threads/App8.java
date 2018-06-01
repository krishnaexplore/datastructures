package org.ds.datastructures.threads;

/**
 * Producer and Consumer with wait and notify mechanism
 * */

public class App8 {

	
	public static void main(String[] args) throws InterruptedException {
		final Processor8 processor = new Processor8();
		Thread t1 = new Thread( new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread( new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}
