package org.ds.datastructures.heap;

import org.ds.datastructures.queue.Queue;

public class PriorityQueue implements Queue{

	private MinHeap heap;
	
	public PriorityQueue() {
		heap = new MinHeap();
	}
	@Override
	public void enQueue(int data) {
		
	}

	@Override
	public int deQueue() {
		return 0;
	}

}
