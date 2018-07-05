package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int balancingFactor = 0;
		if (!node.isEmpty()) {
			balancingFactor = height(castNode(node.getLeft())) - height(castNode(node.getRight()));
		}
		return balancingFactor;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balancingFactor = calculateBalance(node);
		if(balancingFactor > 0) {
			if(calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
				Util.rightRotation(node);
			} else {
				Util.leftRotation((BSTNode<T>) node.getLeft());
				Util.rightRotation(node);
			}
		} else if(balancingFactor < 0) {
			if(calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
				Util.leftRotation(node);
			} else {
				Util.rightRotation((BSTNode<T>) node.getRight());
				Util.leftRotation(node);
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
