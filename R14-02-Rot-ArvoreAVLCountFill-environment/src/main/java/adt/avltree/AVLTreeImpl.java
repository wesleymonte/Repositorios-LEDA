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
		if(balancingFactor > 1) {
			if(calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
				Util.rightRotation(node);
			} else {
				Util.leftRotation((BSTNode<T>) node.getLeft());
				Util.rightRotation(node);
			}
		} else if(balancingFactor < -1) {
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
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while(parent != null) {
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			insertRecursive(null, this.getRoot(), element);
		}
	}

	private void insertRecursive(BSTNode<T> previous, BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(previous);
		} else {
			if (node.getData().compareTo(element) < 0) {
				insertRecursive(node, castNode(node.getRight()), element);
			} else if (node.getData().compareTo(element) > 0) {
				insertRecursive(node, castNode(node.getLeft()), element);
			}
			rebalance(node);
		}
	}
	
	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (!node.isEmpty()) {
				remove(node);
			}
		}
	}

	private void remove(BSTNode<T> node) {
		if (node.isLeaf()) {
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
			rebalanceUp(node);
		} else {
			BSTNode<T> aux = null;
			if (!node.getRight().isEmpty()) {
				aux = treeMinimum(castNode(node.getRight()));
			} else {
				aux = treeMaximum(castNode(node.getLeft()));
			}
			node.setData(aux.getData());
			remove(aux);
		}
	}
}
