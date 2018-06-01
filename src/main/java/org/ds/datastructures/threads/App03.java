package org.ds.datastructures.threads;

public class App03 {

	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public void doWork() {
		
		Thread t1 = new Thread( new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000; i++) {
					increment();
				}
			}
		});
		
		Thread t2 = new Thread( new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000; i++) {
					//count++;
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("count is "+count);
	}
	
	public static void main(String[] args) {
		
		App03 app = new App03();
		app.doWork();
	}
}
