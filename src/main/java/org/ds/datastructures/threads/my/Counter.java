package org.ds.datastructures.threads.my;

public class Counter {

	private  int count;
	
	public synchronized void increment() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<1000;i++)
			count++;
	}
	
	public int getCount() {
		return count;
	}
}
