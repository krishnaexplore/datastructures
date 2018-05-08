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
	
	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}
}
