package selectionSort;

import sorting.AbstractSorting;
import util.Util;

public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int cont = 0;
		for(int i = leftIndex; i < rightIndex; i++) {
			int menor = i;
			for(int j = leftIndex + cont; j <= rightIndex; j++) {
				if(array[j].compareTo(array[menor]) < 0) {
					menor = j;
				}
			}
			Util.swap(array, i, menor);
			cont++;
		}
		
	}
}
