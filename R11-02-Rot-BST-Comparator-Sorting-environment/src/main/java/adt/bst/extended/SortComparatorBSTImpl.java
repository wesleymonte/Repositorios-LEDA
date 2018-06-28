package adt.bst.extended;

import java.util.Comparator;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> rtn = new BSTNode<T>();
		if (element != null) {
			if (this.isEmpty()) {
				// Se a lista for vazia deve automaticamente retornar um NIL
			} else {
				rtn = search(getRoot(), element);
			}
		}
		return rtn;
	}

	private BSTNode<T> search(BSTNode<T> current, T element) {
		BSTNode<T> rtn = new BSTNode<T>();
		if (current.isEmpty() || getComparator().compare(current.getData(), element) == 0) {
			rtn = (castNode(current));
		} else if (getComparator().compare(current.getData(), element) > 0) {
			rtn = search(castNode(current.getLeft()), element);
		} else {
			rtn = search(castNode(current.getRight()), element);
		}
		return rtn;
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.getRoot().setData(element);
				this.getRoot().setLeft(new BSTNode<T>());
				this.getRoot().setRight(new BSTNode<T>());
			} else {
				insertAux(null, this.getRoot(), element);
			}
		}
	}

	private void insertAux(BSTNode<T> previous, BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(previous);
		} else {
			if (getComparator().compare(node.getData(), element) < 0) {
				insertAux(node, castNode(node.getRight()), element);
			} else if (getComparator().compare(node.getData(), element) > 0) {
				insertAux(node, castNode(node.getLeft()), element);
			}
		}
	}
	@Override
	public T[] sort(T[] array) {
		this.root = new BSTNode<T>();
		T[] arraySorted = (T[]) new Comparable[size()]; 
		int i = 0;
		while(i < array.length && array[i] != null) {
			insert(array[i]);
			i++;
		}
		arraySorted = order();
		return arraySorted;
	}

	@Override
	public T[] reverseOrder() {
		T[] array = (T[]) new Comparable[size()];
		reverseOrder(getRoot(), array);
		return array;
	}
	
	private void reverseOrder(BSTNode<T> node, T[] array) {
		if(!node.isEmpty()) {
			reverseOrder(castNode(node.getRight()), array);
			visit(node.getData(), array);
			reverseOrder(castNode(node.getLeft()), array);
		}
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
