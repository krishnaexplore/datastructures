package org.ds.datastructures.threads;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner10 {

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
