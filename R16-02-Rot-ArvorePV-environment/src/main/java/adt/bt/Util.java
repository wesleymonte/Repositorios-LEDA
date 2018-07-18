package adt.bt;

import adt.bst.BSTNode;
import adt.rbtree.RBNode;

public class Util {

	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		if (!node.isEmpty()) {
			BSTNode<T> pivot = (BSTNode<T>) node.getRight();

			BSTNode<T> t1 = (BSTNode<T>) node.getLeft();

			BSTNode<T> t2 = (BSTNode<T>) pivot.getLeft();

			BSTNode<T> t3 = (BSTNode<T>) pivot.getRight();

			node.setLeft(pivot);

			T auxSwap = node.getData();
			BSTNode<T> auxC = new RBNode<T>();
			auxC.setData(node.getData());
			((RBNode<T>) auxC).setColour(((RBNode<T>) node).getColour());

			node.setData(pivot.getData());
			((RBNode<T>) node).setColour(((RBNode<T>) pivot).getColour());

			pivot.setData(auxSwap);
			((RBNode<T>) pivot).setColour(((RBNode<T>) auxC).getColour());

			pivot.setLeft(t1);
			t1.setParent(pivot);
			pivot.setRight(t2);
			t2.setParent(pivot);
			node.setRight(t3);
			t3.setParent(node);
		}

		return node;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		if (!node.isEmpty()) {
			BSTNode<T> pivot = (BSTNode<T>) node.getLeft();

			BSTNode<T> t1 = (BSTNode<T>) node.getRight();
			BSTNode<T> t2 = (BSTNode<T>) pivot.getRight();
			BSTNode<T> t3 = (BSTNode<T>) pivot.getLeft();

			node.setRight(pivot);

			T auxSwap = node.getData();
			BSTNode<T> auxC = new RBNode<T>();
			auxC.setData(node.getData());
			((RBNode<T>) auxC).setColour(((RBNode<T>) node).getColour());

			node.setData(pivot.getData());
			((RBNode<T>) node).setColour(((RBNode<T>) pivot).getColour());

			pivot.setData(auxSwap);
			((RBNode<T>) pivot).setColour(((RBNode<T>) auxC).getColour());

			node.setLeft((BTNode<T>) t3);
			t3.setParent(node);
			pivot.setLeft((BTNode<T>) t2);
			t2.setParent(pivot);
			pivot.setRight((BTNode<T>) t1);
			t1.setParent(pivot);
		}

		return node;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
