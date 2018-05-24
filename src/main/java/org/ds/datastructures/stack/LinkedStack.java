package org.ds.datastructures.stack;

import java.util.LinkedList;

public class LinkedStack<T> implements Stack<T>{

	private LinkedList<T> list;
	
	public LinkedStack() {
		list = new LinkedList<>();
	}
	@Override
	public void push(T data) {
		list.addFirst(data);
	}

	@Override
	public T pop() {
		if(!list.isEmpty())
			return list.removeFirst();
		else 
			return null;
	}

	@Override
	public T peek() {
		return list.getFirst();
	}
	
	public static void main(String args[]) {
		
		LinkedStack<String> l = new LinkedStack<>();
		l.push("a");
		l.push("b");
		l.push("c");
		
		System.out.println(l.peek());
		
		System.err.println(l.pop());
		System.err.println(l.pop());
		System.err.println(l.pop());
		System.err.println(l.pop());
		
		LinkedStack<Integer> ll_int = new LinkedStack<>();
		ll_int.push(1);
		ll_int.push(2);
		ll_int.push(3);
		System.out.println(ll_int.peek());
		
		LinkedStack<CustomeObj> c = new LinkedStack<>();
		c.push(new CustomeObj("elizebeth"));
		c.push(new CustomeObj("charles"));
		c.push(new CustomeObj("diana"));
		
		System.out.println( c.peek() );
	}

	
}

class CustomeObj{
	private String name;
	public CustomeObj(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
