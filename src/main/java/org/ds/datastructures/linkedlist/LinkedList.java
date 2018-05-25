package org.ds.datastructures.linkedlist;

public class LinkedList<T> {

	private LinkedListNode<T> head;
	
	public LinkedList() {
		
	}
	public void add(LinkedListNode<T> node) {
		if(head == null) {
			head = node;
		}else {
			LinkedListNode<T> temp = head;
			LinkedListNode<T> previous = null;
			while(temp!=null) {
				previous = temp;
				temp = temp.getNext();
			}
			previous.setNext(node);
		}
	}
	public void traverse() {
		LinkedListNode<T> temp = head;
		while(temp!=null) {
			System.out.print( temp.getData() +", ");
			temp = temp.getNext();
		}
	}
	
	public LinkedListNode<T> findNthFromEnd(int n) {
		if(head==null)
			return null;
		LinkedListNode<T> current = head;
		LinkedListNode<T> previous = head;
		int count = 0;
		while(current!=null) {
			
			current = current.getNext();
			if(count >= n) {
				previous = previous.getNext();
			}
			count++;
		}
		return previous;
	}
	
	public LinkedListNode<T> findMiddle() {
		if (head == null)
			return null;
		LinkedListNode<T> faster = head;
		LinkedListNode<T> slower = head;
		while (faster != null && faster.getNext()!=null) {
			faster = faster.getNext().getNext();
			slower = slower.getNext();
		}
		return slower;
	}
	
	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}
}
