package org.ds.datastructures.queue;

public class ArrayQueue implements Queue {

	private int[] data;
	private int size;
	private int front;
	private int rear;
	private final int defaultCapacity = 10;
	public ArrayQueue() {
		data = new int[defaultCapacity];
		this.size = 0;
		front = 0;
		rear = 9;
	}
	
	private boolean isFull() {
		return size == defaultCapacity;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public void enQueue(int data) {
		if( isFull( ) )
			return;
		this.rear = (this.rear + 1)%this.defaultCapacity;
		this.data[rear] = data;
		this.size++;
	}

	@Override
	public int deQueue() {
		if(isEmpty())
			return -1;
		int item = data[this.front];
        front = (front + 1)%this.defaultCapacity;
        this.size--;
        return item;
	}
	
	public int front() {
		if(isEmpty())
			return -1;
		return data[front];
	}
	public int rear() {
		if(isEmpty())
			return -1;
		return data[rear];
	}
}
