package selectionSort;

import sorting.AbstractSorting;
import util.Util;

public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		for(int i = leftIndex; i < rightIndex; i++) {
			int menor = i;
			for(int j = i + 1; j <= rightIndex; j++) {
				if(array[j].compareTo(array[menor]) < 0) {
					menor = j;
				}
			}
			Util.swap(array, i, menor);
		}
		
	}
}
