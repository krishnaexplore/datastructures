package org.ds.datastructures.threads;

import java.util.Scanner;

class Processor2 extends Thread{
	
	private boolean running = true; // this may cached in each thread, make volatile -> volatile makes threads not to cache
	@Override
	public void run() {
		while(running) {
			System.out.println("hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void shutdown() {
		running = false;
	}
}
public class App02 {

	//cache
	public static void main(String[] args) {
		Processor2 proc1 = new Processor2();
		proc1.start();
		System.out.println("press return key");
		Scanner s = new Scanner(System.in);
		s.nextLine();
		proc1.shutdown();
		s.close();
		
		
	}
}
