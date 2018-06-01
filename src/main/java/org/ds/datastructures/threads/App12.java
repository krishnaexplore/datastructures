package org.ds.datastructures.threads;

/**
 * Usage of Semaphore
 * */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App12 {

	public static void main(String[] args) throws Exception{
		
		Connection12.getInstace().connect();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0; i<200;i++) {
			
			executor.submit(new Runnable() {
				@Override
				public void run() {
					Connection12.getInstace().connect();

				}
			});
		}
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}
}
