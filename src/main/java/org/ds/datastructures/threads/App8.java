package org.ds.datastructures.threads;

/**
 * Producer and Consumer with wait and notify mechanism
 * */

import java.util.Scanner;

class Processor8 {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running.......");
			wait();
			System.out.println("Resumed.........");
		}
	}
	
	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting from wait key");
			scanner.nextLine();
			System.out.println("return key pressed");
			notify();
			Thread.sleep(5000);
		}
	}
}
public class App8 {

	
	public static void main(String[] args) throws InterruptedException {
		final Processor8 processor = new Processor8();
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
