package adt.avltree;

import java.util.Arrays;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	protected void rebalance(BSTNode<T> node) {
		int balancingFactor = calculateBalance(node);
		if (balancingFactor > 1) {
			if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
				LLcounter++;
			} else {
				Util.leftRotation((BSTNode<T>) node.getLeft());
				LRcounter++;
			}
			Util.rightRotation(node);
		} else if (balancingFactor < -1) {
			if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
				RRcounter++;
			} else {
				Util.rightRotation((BSTNode<T>) node.getRight());
				RLcounter++;
			}
			Util.leftRotation(node);
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
		if (isEmpty()) {
			Arrays.sort(array, 0, array.length - 1);
			T[] sortedAVL = (T[]) new Comparable[array.length];
			sortForAVL(array, 0, array.length - 1, sortedAVL);
			insertInAVL(sortedAVL);
		} else {
			T[] oldAVL = order();
			this.root = new BSTNode<T>();
			T[] newAVL = concatenateArrays(oldAVL, array);
			Arrays.sort(array, 0, array.length - 1);
			
			T[] sortedAVL = (T[]) new Comparable[newAVL.length];
			
			sortForAVL(newAVL, 0, newAVL.length - 1, sortedAVL);
			insertInAVL(sortedAVL);
		}
	}
	
	private void insertInAVL(T[] sortedArray) {
		int l1 = (sortedArray.length - 1) / 2;
		int l2 = (sortedArray.length - 1) - l1;
		T[] array1 = (T[]) new Comparable[l1];
		T[] array2 = (T[]) new Comparable[l2];
		
		insert(sortedArray[0]);
		
		System.arraycopy(sortedArray, 1, array1, 0, l1);
		System.arraycopy(sortedArray, l1 + 1, array2, 0, l2);
		
		int i = 0;
		insert(array1[i]);
		insert(array2[i]);
		i++;
		
		if(l1 == l2) {
			while(i + 3 < l1) {
				insert(array1[i]);
				insert(array1[i + 3]);
				insert(array2[i]);
				insert(array2[i + 3]);
				i++;
			}
		} else {
			while(i + 2 <= l1) {
				if(i + 3 == l1) {
					insert(array1[i + 2]);
					insert(array2[i]);
					insert(array2[i + 3]);
					break;
				} else {
					insert(array1[i]);
					insert(array1[i + 2]);
					insert(array2[i]);
					insert(array2[i + 3]);
					i++;
				}
			}
			
		}
		
	}

	private void sortForAVL(T[] array, int leftIndex, int rightIndex, T[] ordenado) {
		if (validateInput(array, leftIndex, rightIndex)) {
			int middle = (rightIndex + leftIndex) / 2;
			insertInArray(ordenado, array[middle]);
			sortForAVL(array, leftIndex, middle - 1, ordenado);
			sortForAVL(array, middle + 1, rightIndex, ordenado);
		}
	}

	private void insertInArray(T[] array, T element) {
		int i = 0;
		while(i < array.length && array[i] != null) {
			i++;
		}
		if(i < array.length && array[i] == null) {
			array[i] = element;
		}
	}

	private boolean validateInput(Object[] array, int leftIndex, int rightIndex) {
		boolean valid = false;
		if (array != null && array.length > 1 && rightIndex < array.length && leftIndex >= 0
				&& rightIndex >= leftIndex) {
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
