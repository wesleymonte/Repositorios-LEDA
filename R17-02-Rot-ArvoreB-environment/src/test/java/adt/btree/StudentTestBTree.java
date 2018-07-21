package adt.btree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StudentTestBTree {

	protected BTree<Integer> tree1;
	protected BTree<Integer> tree2;

	@Before
	public void setUp() throws Exception {
		tree1 = new BTreeImpl<Integer>(4);
		tree2 = new BTreeImpl<Integer>(3);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(tree1.isEmpty());
	}

	@Test
	public void testHeight() {
		assertEquals(-1, tree1.height());
		tree1.insert(2);
		assertEquals(0, tree1.height());
	}

	@Test
	public void testDepthLeftOrder() {
		tree1.insert(2);
		tree1.insert(4);
		tree1.insert(6);
		tree1.insert(8);
		try {
			assertEquals("[[6], [2, 4], [8]]",
					Arrays.toString(tree1.depthLeftOrder()));
		} catch (AssertionError e) {
			assertEquals("[[4], [2], [6, 8]]",
					Arrays.toString(tree1.depthLeftOrder()));
		}
	}

	@Test
	public void testSize() {
		assertEquals(0, tree1.size());
		tree1.insert(18);
		assertEquals(1, tree1.size());
	}
	
	@Test
	public void testPuloDoGato() {
		tree2.insert(1);
		tree2.insert(2);
		tree2.insert(3);
		tree2.insert(4);
		tree2.insert(5);
		tree2.insert(6);
		System.out.println("Tamanho: " + tree2.size());
		System.out.println("Altura: " + tree2.height());
		System.out.println(Arrays.toString(tree2.depthLeftOrder()));
		tree2.insert(7);
		System.out.println(Arrays.toString(tree2.depthLeftOrder()));
		System.out.println("Tamanho: " + tree2.size());
		System.out.println("Altura: " + tree2.height());
		BNodePosition<Integer> s = tree2.search(7);
		System.out.println(s.node.getParent().getElements().getFirst() + " " + s.position);
	}

}
