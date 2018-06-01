package org.ds.datastructures.threads.my;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Counter counter = new Counter();
		for(int i=0; i<10;i++) {
			executor.submit( () -> counter.increment() );
		}
		
		executor.shutdown();
		
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println(  counter.getCount() );
	}
}
