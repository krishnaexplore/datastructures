package org.ds.datastructures.threads;

import java.util.LinkedList;
import java.util.Random;

class Processor9 {
	
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int limit = 10;
	
	private Object lock = new Object();

	public void produce() throws InterruptedException{
		
		int value = 0;
		while(true) {
			synchronized (lock) {
				
				while(list.size() == limit) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}
	
	public void consume() throws InterruptedException{
		Random random = new Random();
		while(true) {
			
			synchronized (lock) {
				while(list.isEmpty()) {
					lock.wait();
				}
				System.out.print( "List size is ;"+list.size());
				int value = list.removeFirst();
				System.out.println( "; value is ; "+value);
				lock.notify();
			}
			
			Thread.sleep(random.nextInt(1000));
			
		}
	}
}

/**
 * Producer Consumer problem with help of locks
 * */
public class App09 {

	public static void main(String[] args) throws InterruptedException {
		final Processor9 processor = new Processor9();
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
