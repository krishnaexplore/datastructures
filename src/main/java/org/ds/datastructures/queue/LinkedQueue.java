package org.ds.datastructures.queue;

import org.ds.datastructures.linkedlist.LinkedListNode;

public class LinkedQueue implements Queue {

	private LinkedListNode<Integer> rear;
	private LinkedListNode<Integer> front;
	@Override
	public void enQueue(int data) {

		LinkedListNode<Integer> temp = new LinkedListNode<>(data);
		if( rear == null) {
			rear = front = temp;
		}else {
			rear.setNext( temp );
			rear = temp;
		}
	}
	
	private boolean isEmpty() {
		return front == null;
	}
	
	public int front() {
		if(isEmpty())
			return -1;
		return front.getData();
	}
	
	public int rear() {
		if(isEmpty())
			return -1;
		return rear.getData();
	}

	@Override
	public int deQueue() {
		if(isEmpty())
			return -1;
		LinkedListNode<Integer> temp = front;
		front = front.getNext();
		if(isEmpty())
			rear = null;
		return temp.getData();
	}
}
