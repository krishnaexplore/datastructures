package org.ds.datastructures.threads;

/**
 * Usage of Semaphore
 * */



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


class Connection12 {

	private static Connection12 instance = new Connection12();
	
	private Semaphore sem = new Semaphore(10);	
	private Connection12() {
		
	}
	
	private int connections = 0;
	public static Connection12 getInstace() {
		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			doConnect();
			
		}finally {
			sem.release();
		}
	}
	public void doConnect() {
		
		
		synchronized (this) {
			connections++;
			
			System.out.println("current connections.....;"+connections);
		}
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		
		synchronized(this) {
			connections--;
		}
		
	}
	
}

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
