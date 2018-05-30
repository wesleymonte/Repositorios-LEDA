package adt.linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.queue.QueueDoubleLinkedListImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class QueueTest {

	private QueueDoubleLinkedListImpl<Integer> queue1;
	private QueueDoubleLinkedListImpl<Integer> queue2;
	private QueueDoubleLinkedListImpl<Integer> queue3;
	
	@Before
	public void setUp() throws Exception {
		
		getImplementations();
		
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		
		queue2.enqueue(9);
	}
	
	private void getImplementations() {
		queue1 = new QueueDoubleLinkedListImpl<Integer>(3);
		queue2 = new QueueDoubleLinkedListImpl<Integer>(2);
		queue3 = new QueueDoubleLinkedListImpl<Integer>(1);
	}

	@Test
	public void testIsFullQueue1() {
		assertTrue(queue1.isFull());
	}
	
	@Test
	public void testIsEmptyQueue1() {
		assertFalse(queue1.isEmpty());
	}
	
	@Test
	public void testDequeueQueue1() throws QueueUnderflowException {
		queue1.dequeue();
		assertEquals(new Integer(2), queue1.head());
	}
	
	@Test
	public void testDequeueAllQueue1() throws QueueUnderflowException {
		queue1.dequeue();
		queue1.dequeue();
		queue1.dequeue();
		assertTrue(queue1.isEmpty());
	}
	
	@Test
	public void testHeadQueue1() {
		assertEquals(new Integer(1), queue1.head());
	}
	
	@Test(expected = QueueOverflowException.class)
	public void testEnqueueQueue1() throws QueueOverflowException {
		queue1.enqueue(4);
	}
	
	@Test(expected = QueueUnderflowException.class)
	public void testEnqueueQueue2() throws QueueUnderflowException {
		queue2.dequeue();
		queue2.dequeue();
	}
	
	

}
