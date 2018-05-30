package adt.linkedList;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {

	public SingleLinkedListImpl<Integer> linkedlist1;
	public SingleLinkedListImpl<Integer> linkedlist2;
	public SingleLinkedListImpl<Integer> linkedlist3;
	

	@Before
	public void setUp() throws Exception {
		
		getImplementations();
		
		linkedlist1.insert(3);
		linkedlist1.insert(5);
		linkedlist1.insert(1);
		
		linkedlist2.insert(9);
	}
	
	private void getImplementations() {
		linkedlist1 = new SingleLinkedListImpl<>();
		linkedlist2 = new SingleLinkedListImpl<>();
		linkedlist3 = new SingleLinkedListImpl<>();
	}

	@Test
	public void testSearchList1() {
		assertEquals(new Integer(3), linkedlist1.search(3));
		assertEquals(new Integer(5), linkedlist1.search(5));
		assertEquals(new Integer(1), linkedlist1.search(1));
	}
	
	@Test
	public void testSearchList2() {
		assertEquals(new Integer(9), linkedlist2.search(9));
	}
	
	@Test
	public void testSearchList3() {
		assertEquals(null, linkedlist3.search(1));
	}
	
	@Test
	public void testSizeList1() {
		assertEquals(3, linkedlist1.size());
	}
	
	@Test
	public void testSizeList2() {
		assertEquals(1, linkedlist2.size());
	}
	
	@Test
	public void testSizeList3() {
		assertEquals(0, linkedlist3.size());
	}
	
	@Test
	public void testIsEmptyTrue() {
		assertTrue(linkedlist3.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse1() {
		assertFalse(linkedlist1.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse2() {
		assertFalse(linkedlist2.isEmpty());
	}
	
	@Test
	public void removeLeftList1() {
		linkedlist1.remove(3);
		assertEquals(null, linkedlist1.search(3));
		System.out.println(Arrays.toString(linkedlist1.toArray()));
	}
	
	@Test
	public void removeMiddleList1() {
		linkedlist1.remove(5);
		assertEquals(null, linkedlist1.search(5));
		System.out.println(Arrays.toString(linkedlist1.toArray()));
	}
	
	@Test
	public void removeLastList1() {
		linkedlist1.remove(1);
		assertEquals(null, linkedlist1.search(1));
		System.out.println(Arrays.toString(linkedlist1.toArray()));
	}
	
	@Test
	public void remoreAllList1() {
		linkedlist1.remove(3);
		linkedlist1.remove(5);
		linkedlist1.remove(1);
		assertTrue(linkedlist1.isEmpty());
	}
	
	@Test
	public void removeList3() {
		linkedlist3.remove(1);
	}
	
	@Test
	public void toArrayList3() {
		System.out.println(Arrays.toString(linkedlist3.toArray()));
	}

}
