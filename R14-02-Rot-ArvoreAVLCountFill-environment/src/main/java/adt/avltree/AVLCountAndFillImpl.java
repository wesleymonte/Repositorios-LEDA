package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}
	
	@Override
	protected void rebalance(BSTNode<T> node) {
		int balancingFactor = calculateBalance(node);
		if(balancingFactor > 1) {
			if(calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
				Util.rightRotation(node);
				LLcounter++;
			} else {
				Util.leftRotation((BSTNode<T>) node.getLeft());
				Util.rightRotation(node);
				LRcounter++;
			}
		} else if(balancingFactor < -1) {
			if(calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
				Util.leftRotation(node);
				RRcounter++;
			} else {
				Util.rightRotation((BSTNode<T>) node.getRight());
				Util.leftRotation(node);
				RLcounter++;
			}
		}
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		if(isEmpty()) {
			quickSort(array, 0, array.length);
			insertMiddle(array, 0, array.length);
		} else {
			T[] oldAVL = order();
			this.root = new BSTNode<T>();
			T[] newAVL = concatenateArrays(oldAVL, array);
			quickSort(newAVL, 0, newAVL.length);
			insertMiddle(newAVL, 0, newAVL.length);
		}
	}
	
	
	private void insertMiddle(T[] array, int leftIndex, int rightIndex) {
		if(validateInput(array, leftIndex, rightIndex)) {
			int middle = (rightIndex - leftIndex) / 2;
			insert(array[middle]);
			insertMiddle(array, leftIndex, middle - 1);
			insertMiddle(array, middle + 1, rightIndex);
		}
	}
	
	private void quickSort(T[] array, int leftIndex, int rightIndex) {
		if(validateInput(array, leftIndex, rightIndex)) {
			int pi = partition(array ,leftIndex, rightIndex);
			quickSort(array, leftIndex, pi - 1);
			quickSort(array, pi + 1, rightIndex);
		}
	}
	
	private int partition(T[] array, int leftIndex, int rightIndex) {
		int pivot = rightIndex;
		int i = leftIndex - 1;
		
		for(int j = leftIndex; j < rightIndex; j++) {
			if(array[j].compareTo(array[pivot]) <= 0) {
				swap(array, ++i, j);
			}
		}
		swap(array, pivot, ++i);
		return i;
	}
	
	private void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = array[i];
	}
	
	private boolean validateInput(Object[] array, int leftIndex, int rightIndex) {
		boolean valid = false;
		if(array != null && array.length > 1 && rightIndex < array.length && leftIndex >= 0 && rightIndex > leftIndex) {
			valid = true;
		}
		return valid;
	}
	
	private T[] concatenateArrays(T[] array1, T[] array2) {
		T[] rtn = (T[]) new Comparable[array1.length + array2.length];
		System.arraycopy(array1, 0, rtn, 0, array1.length);
		System.arraycopy(array2, 0, rtn, array1.length, array2.length);
		return rtn;
	}

}
