package org.ds.datastructures.threads;

class Runner extends Thread{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("hello  "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class RunnerRunnable implements Runnable{
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("hello  "+i+"  "+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class App01 {

	public static void main(String[] args) {
		
		/*Runner runner1 = new Runner();
		
		runner1.start();
		
		Runner runner2 = new Runner();
		
		runner2.start();
		
		RunnerRunnable runnable = new RunnerRunnable();
		
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		
		t1.start();
		t2.start();*/
		
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println("hello  "+i+"  "+Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println("hello  "+i+"  "+Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
		
		System.out.println("finished main thread");
	}
}
