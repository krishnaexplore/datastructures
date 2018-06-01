package org.ds.datastructures.threads;

import java.util.Scanner;

public class Processor8 {

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
