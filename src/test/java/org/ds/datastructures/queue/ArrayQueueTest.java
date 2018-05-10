package org.ds.datastructures.queue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {

	private ArrayQueue target;
	
	@Before
	public void setUp() {
		target = new ArrayQueue();
	}
	
	@Test
	public void testBasicOperations() {
		target.enQueue(10);
		target.enQueue(20);
		target.enQueue(30);
		target.enQueue(40);
		target.enQueue(50);
		target.enQueue(60);
		target.enQueue(70);
		target.enQueue(80);
		target.enQueue(90);
		target.enQueue(100);
		target.enQueue(110);
		assertEquals(10, target.front() );
		assertEquals(100, target.rear() );
		assertEquals(100, target.deQueue() );
	}
}
