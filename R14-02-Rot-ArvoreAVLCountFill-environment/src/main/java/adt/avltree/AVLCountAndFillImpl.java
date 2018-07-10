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
			T[] xxx = (T[]) new Comparable[array.length];
			quickSort(array, 0, array.length);
			insertMiddle(array, 0, array.length - 1, xxx);
		} else {
			T[] oldAVL = order();
			this.root = new BSTNode<T>();
			T[] newAVL = concatenateArrays(oldAVL, array);
			Arrays.sort(newAVL);
			
			T[] ordenado = (T[]) new Comparable[array.length];
			
			insertMiddle(newAVL, 0, newAVL.length - 1, ordenado);

			int i = 0;
			int j = (ordenado.length / 2) + 1;
			int cont = 0;
			while (j < ordenado.length) {
				for (int k = 0; k < Math.pow(2, cont); k++) {
					insert(array[i]);
					i++;
				}
				for (int k = 0; k < Math.pow(2, cont); k++) {
					insert(array[j]);
					j++;
				}
				cont++;
			}
		}
	}

	private T[] insertMiddle(T[] array, int leftIndex, int rightIndex, T[] ordenado) {
		if (validateInput(array, leftIndex, rightIndex)) {
			int middle = (rightIndex + leftIndex) / 2;
			insertArray(ordenado, array[middle]);
			insertMiddle(array, leftIndex, middle - 1, ordenado);
			insertMiddle(array, middle + 1, rightIndex, ordenado);
		}
		return ordenado;
	}

	private void insertArray(T[] array, T x) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = x;
			}
		}
	}

	private void quickSort(T[] array, int leftIndex, int rightIndex) {
		if (validateInput(array, leftIndex, rightIndex)) {
			int pi = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pi - 1);
			quickSort(array, pi + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		int pivot = rightIndex;
		int i = leftIndex - 1;

		for (int j = leftIndex; j < rightIndex; j++) {
			if (array[j].compareTo(array[pivot]) <= 0) {
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
