package org.ds.datastructures.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * Resovling producer and consumer problem with help of BlockingQueue
 * */
public class App7 {

	private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
	
	private static void producer() throws InterruptedException {
		Random random = new Random();
		while(true) {
		 blockingQueue.put(random.nextInt(100));	
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			Thread.sleep(100);

			//if(random.nextInt(10) == 0) {
				Integer value = blockingQueue.take();
				System.out.println("Taken value : "+value+"; QUeue size is: "+blockingQueue.size());
			//}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {

				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {

				try {
					consumer();
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
