package adt.rbtree;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Before;

import adt.rbtree.RBNode.Colour;

public class StudentTestRBTree {

	public RBTreeImpl<Integer> myRB;

	@Before
	public void initialize() {
		myRB = new RBTreeImpl<Integer>();
	}

	@Test
	public void testInsert0() {
		Integer[] preOrder = { 11 };
		Colour[] preOrderColour = { Colour.BLACK };

		myRB.insert(11);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert1() {
		Integer[] preOrder = { 11, 2 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert2() {
		Integer[] preOrder = { 11, 2, 14 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.RED, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert3() {
		Integer[] preOrder = { 11, 2, 1, 14 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.BLACK, Colour.RED,
				Colour.BLACK };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);
		myRB.insert(1);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert4() {
		Integer[] preOrder = { 11, 2, 1, 14, 15 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.BLACK, Colour.RED,
				Colour.BLACK, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);
		myRB.insert(1);
		myRB.insert(15);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert5() {
		Integer[] preOrder = { 11, 2, 1, 7, 14, 15 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.BLACK, Colour.RED,
				Colour.RED, Colour.BLACK, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);
		myRB.insert(1);
		myRB.insert(15);
		myRB.insert(7);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}

	@Test
	public void testInsert6() {
		Integer[] preOrder = { 11, 2, 1, 7, 5, 14, 15 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.RED, Colour.BLACK,
				Colour.BLACK, Colour.RED, Colour.BLACK, Colour.RED };

		myRB.insert(11);
		myRB.insert(2);
		myRB.insert(14);
		myRB.insert(1);
		myRB.insert(15);
		myRB.insert(7);
		myRB.insert(5);

		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());
	}
	
	@Test
	public void testInsert7() {
		myRB.insert(11);
		myRB.insert(4);
		myRB.insert(5);
		
		Integer[] preOrder = new Integer[] {5, 4, 11};
		Colour[] preOrderColour = {Colour.BLACK, Colour.RED, Colour.RED};
		
		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		System.out.println(Arrays.toString(result));
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		
		
		assertTrue(myRB.verifyProperties());;
	}
	
	@Test
	public void testInsert8() {
		Integer[] preOrder = { 19, 7, 3, 2, 12, 28, 24, 65, 41, 85 };
		Colour[] preOrderColour = { Colour.BLACK, Colour.RED, Colour.BLACK,
				Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK, Colour.BLACK, Colour.RED, Colour.RED };

		myRB.insert(28);
		myRB.insert(12);
		myRB.insert(19);
		
		System.out.println(Arrays.toString(myRB.rbPreOrder()));
		
		myRB.insert(3);
		System.out.println(Arrays.toString(myRB.rbPreOrder()));
		myRB.insert(7);
		System.out.println(Arrays.toString(myRB.rbPreOrder()));
		
		myRB.insert(85);
		System.out.println(Arrays.toString(myRB.rbPreOrder()));
		
		myRB.insert(24);
		System.out.println(Arrays.toString(myRB.rbPreOrder()));
		
		myRB.insert(41);
		System.out.println(Arrays.toString(myRB.rbPreOrder()));
		
		myRB.insert(65);
		myRB.insert(2);
		System.out.println(Arrays.toString(myRB.rbPreOrder()));
		
		int len = myRB.size();
		RBNode<Integer>[] result = myRB.rbPreOrder();
		for (int i = 0; i < len; i++) {
			assertEquals(preOrder[i], result[i].getData());
			assertEquals(preOrderColour[i], result[i].getColour());
		}
		assertTrue(myRB.verifyProperties());

	}

}
