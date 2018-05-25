package org.ds.datastructures;

import org.ds.datastructures.linkedlist.LinkedList;
import org.ds.datastructures.linkedlist.LinkedListNode;

public class DatastructuresApplication {

	public static void main(String args[]) {
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
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(l1);
		linkedList.add(l2);
		linkedList.add(l3);
		linkedList.add(l4);
		linkedList.add(l5);
		linkedList.add(l6);
		linkedList.add(l7);
		linkedList.add(l8);
		linkedList.add(l9);
		linkedList.add(l10);
		
		//linkedList.traverse();
		//System.out.println( linkedList.findNthFromEnd(2) );
		
		System.out.println( linkedList.findMiddle() );
	}
}
