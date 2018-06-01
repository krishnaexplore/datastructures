package org.ds.datastructures.threads;

import java.util.concurrent.Semaphore;

public class Connection12 {

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
