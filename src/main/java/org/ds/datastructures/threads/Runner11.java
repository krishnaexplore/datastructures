package org.ds.datastructures.threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner11 {
	
	private Account11 acc1 = new Account11();
	private Account11 acc2 = new Account11();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	private void acquireLocks(Lock firstLock, Lock SecondLock) throws InterruptedException {
		//firstLock.tryLock();
		
		while(true) {
			//Acquire locks
			
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			
			try {
			gotFirstLock = firstLock.tryLock();
			gotSecondLock = SecondLock.tryLock();
			}finally {
				if(gotFirstLock&& gotSecondLock) {
					return;
				}
				if(gotFirstLock) {
					firstLock.unlock();
				}
				if(gotSecondLock) {
					SecondLock.unlock();
				}
			}
			
			//locks not acquired
			
			//sleep
			Thread.sleep(1);
		}
	}
	
	public void firstThread() throws InterruptedException{
		Random rand = new Random();
		for(int i = 0 ; i<10000;i++) {
			//lock1.lock();
			//lock2.lock();
			
			acquireLocks(lock1,lock2);
			try {
			Account11.transfer(acc1, acc2, rand.nextInt(100));
			}finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	public void secondThread()  throws InterruptedException{
		
		Random rand = new Random();
		for(int i = 0 ; i<10000;i++) {
			//lock1.lock();
			//lock2.lock();
			
//			lock2.lock();
//			lock1.lock();//causes deadlock
			
			acquireLocks(lock2,lock1);
			
			try {
			Account11.transfer(acc2, acc1, rand.nextInt(100));
			}finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	public void finished() {
		
		System.out.println("Account 1 balance: "+acc1.getBalance());
		System.out.println("Account 2 balance: "+acc2.getBalance());
		System.out.println("Total balance: "+(acc1.getBalance() + acc2.getBalance()));
	
	}
}
