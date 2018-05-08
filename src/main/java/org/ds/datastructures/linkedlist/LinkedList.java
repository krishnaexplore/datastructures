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
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		LinkedListNode<Integer> l1 = new LinkedListNode<>(1);
		LinkedListNode<Integer> l2 = new LinkedListNode<>(2);
		LinkedListNode<Integer> l3 = new LinkedListNode<>(3);
		LinkedListNode<Integer> l4 = new LinkedListNode<>(4);
		LinkedListNode<Integer> l5 = new LinkedListNode<>(5);
		LinkedListNode<Integer> l6 = new LinkedListNode<>(6);
		LinkedListNode<Integer> l7 = new LinkedListNode<>(7);
		LinkedListNode<Integer> l8 = new LinkedListNode<>(8);
		LinkedListNode<Integer> l9 = new LinkedListNode<>(9);
		LinkedListNode<Integer> l10 = new LinkedListNode<>(10);
		ll.add(l1);
		ll.add(l2);
		ll.add(l3);
		ll.add(l4);
		ll.add(l5);
		ll.add(l6);
		ll.add(l7);
		ll.add(l8);
		ll.add(l9);
		ll.add(l10);
		
		ll.traverse();
	}
}
