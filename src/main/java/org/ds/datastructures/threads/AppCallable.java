package org.ds.datastructures.threads;

/**
 * Usage of Callable Interface
 * */

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppCallable {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		/*executor.submit( new Runnable() {
			@Override
			public void run() {
				Random rand = new Random();
				int duration = rand.nextInt(4000);
				System.out.println("starting ;...thread;  "+Thread.currentThread().getName() );
				
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("finished ;...thread;  "+Thread.currentThread().getName() );
			}
		});*/
		
		Future<Integer> future = executor.submit( new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Random rand = new Random();
				int duration = rand.nextInt(4000);
				System.out.println("starting ;...thread;  "+Thread.currentThread().getName() );
				
				if(duration > 2000) {
					throw new IOException("tooo long sleeping");
				}
				
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("finished ;...thread;  "+Thread.currentThread().getName() );
				return duration;
			}
		});
		
		try {
			System.out.println( future.get() );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdown();
		
	}
}
