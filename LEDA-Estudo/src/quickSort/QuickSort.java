package quickSort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int m = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, m - 1);
			sort(array, m + 1, rightIndex);
		}
	}
	
	public int partition(T[] array, int leftIndex, int rightIndex) {
		int pivot = rightIndex;
		int i = leftIndex - 1;
		
		for(int j = leftIndex; j < rightIndex; j++) {
			if(array[pivot].compareTo(array[j]) > 0) {
				i++;
				Util.swap(array, j, i);
			}
		}
		
		Util.swap(array, i + 1, pivot);
		return i + 1;
		
	}
	
	public static void main(String[] args) {
		Integer[] i1 = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		QuickSort<Integer> qs = new QuickSort<>();
		qs.sort(i1);
		System.out.println(Arrays.toString(i1));
	}

}
