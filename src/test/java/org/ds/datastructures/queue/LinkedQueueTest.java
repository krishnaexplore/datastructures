package org.ds.datastructures.queue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LinkedQueueTest {

	private LinkedQueue target;

	@Before
	public void setUp() {
		target = new LinkedQueue();
	}

	@Test
	public void testBasicOperations() {
		target.enQueue(10);
		target.enQueue(20);
		target.enQueue(30);
		target.enQueue(40);
		target.enQueue(50);
		assertEquals(10, target.deQueue());
		assertEquals(20, target.deQueue());
		assertEquals(30, target.deQueue());
		assertEquals(40, target.deQueue());
		assertEquals(50, target.deQueue());
		assertEquals(-1, target.deQueue()); // current implementation returning -1 if queue is empty
	}

}
