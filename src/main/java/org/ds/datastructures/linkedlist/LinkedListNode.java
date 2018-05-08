package org.ds.datastructures.linkedlist;

public class LinkedListNode<T> {

	private T data;
	private LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
}
