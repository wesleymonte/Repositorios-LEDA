package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AVLTest {
	
	AVLTreeImpl<Integer> avl;

	@Before
	public void setUp() throws Exception {
		avl = new AVLTreeImpl<Integer>();
	}

	@Test
	public void testWar_haha() {
		avl.insert(1);  avl.insert(2);  avl.insert(3);  avl.insert(4);  avl.insert(5);
		avl.insert(6);  avl.insert(7);  avl.insert(8);  avl.insert(9);  avl.insert(10);
		avl.insert(11); avl.insert(12); avl.insert(13); avl.insert(14); avl.insert(15);
		avl.insert(null); 
		
		assertEquals(3, avl.height());
		
		assertArrayEquals(new Integer[] {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15}, avl.preOrder());
		assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, avl.order());
		assertArrayEquals(new Integer[] {1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8}, avl.postOrder());
		
		
		avl.remove(2);   avl.remove(6); avl.remove(10); avl.remove(14);
		avl.remove(517); avl.remove(-256); avl.remove(null);

		assertEquals(3, avl.height());
		
		assertArrayEquals(new Integer[] {8, 4, 3, 1, 7, 5, 12, 11, 9, 15, 13}, avl.preOrder());
		assertArrayEquals(new Integer[] {1, 3, 4, 5, 7, 8, 9, 11, 12, 13, 15}, avl.order());
		assertArrayEquals(new Integer[] {1, 3, 5, 7, 4, 9, 11, 13, 15, 12, 8}, avl.postOrder());
		
		
		avl.remove(1); avl.remove(3);
		
		assertEquals(3, avl.height());
		
		assertArrayEquals(new Integer[] {8, 5, 4, 7, 12, 11, 9, 15, 13}, avl.preOrder());
		assertArrayEquals(new Integer[] {4, 5, 7, 8, 9, 11, 12, 13, 15}, avl.order());
		assertArrayEquals(new Integer[] {4, 7, 5, 9, 11, 13, 15, 12, 8}, avl.postOrder());
		
		
		avl.remove(13); avl.remove(15);
		
		assertEquals(2, avl.height());
		
		assertArrayEquals(new Integer[] {8, 5, 4, 7, 11, 9, 12}, avl.preOrder());
		assertArrayEquals(new Integer[] {4, 5, 7, 8, 9, 11, 12}, avl.order());
		assertArrayEquals(new Integer[] {4, 7, 5, 9, 12, 11, 8}, avl.postOrder());
		
		
		avl.remove(8); avl.remove(9); avl.remove(11);
		
		assertEquals(2, avl.height());
		
		assertArrayEquals(new Integer[] {5, 4, 12, 7}, avl.preOrder());
		assertArrayEquals(new Integer[] {4, 5, 7, 12}, avl.order());
		assertArrayEquals(new Integer[] {4, 7, 12, 5}, avl.postOrder());
		
		
		avl.remove(4);
		
		assertEquals(1, avl.height());
		
		assertArrayEquals(new Integer[] {7, 5, 12}, avl.preOrder());
		assertArrayEquals(new Integer[] {5, 7, 12}, avl.order());
		assertArrayEquals(new Integer[] {5, 12, 7}, avl.postOrder());
		
		
		avl.remove(7); avl.remove(12);
		
		assertEquals(0, avl.height());
		
		avl.remove(5); avl.remove(null); avl.remove(-97);
		
		assertEquals(-1, avl.height());
		
		assertArrayEquals(new Integer[] {}, avl.preOrder());
		assertArrayEquals(new Integer[] {}, avl.order());
		assertArrayEquals(new Integer[] {}, avl.postOrder());
		
	}

}
