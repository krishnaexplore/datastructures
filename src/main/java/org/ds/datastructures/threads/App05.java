package org.ds.datastructures.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor5 implements Runnable{
	
	private int id;
	public Processor5(int id) {
		this.id = id;
	}
	@Override
	public void run() {

		System.out.println("starting...."+id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("completed...."+id);
	}
}


/**
 * 
 * */
public class App05 {

	public static void main(String[] args) {
		
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=0; i<5; i++) {
			Processor5 s = new Processor5(i);
			executor.submit(s);
		}
		
		executor.shutdown();
		
		System.out.println("All tasks are submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks are completed");
}
}
