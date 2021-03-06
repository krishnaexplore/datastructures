package org.ds.datastructures.threads;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner10 {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private void increment() {
		
		for(int i = 0; i<10000; i++) {
			count++;
		}
	}
	public void firstThread() throws InterruptedException{
		lock.lock();
		System.out.println("waiting..");
		cond.await();
		
		System.err.println("awke do the work");
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	public void secondThread()  throws InterruptedException{
		Thread.sleep(1000);
		lock.lock();
		System.out.println("press the return key");
		Scanner s = new Scanner(System.in);
		s.nextLine();
		System.out.println("got retur key");
		s.close();
		cond.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	
	public void finished() {
		System.out.println("count is :  "+count);
	}
}


public class App10 {

	public static void main(String[] args) throws InterruptedException {
		
		final Runner10 runner = new Runner10();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					runner.secondThread();
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
		
		runner.finished();	
	}
}
