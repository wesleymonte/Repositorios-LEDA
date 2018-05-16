package bubbleSort;

import sorting.AbstractSorting;
import util.Util;

public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int cont = -1;
		boolean swapped;
		for(int i = leftIndex; i < rightIndex; i++) {
			swapped = false;
			cont ++;
			for(int j = leftIndex; j < rightIndex - cont; j++) {
				if(array[j].compareTo(array[j + 1]) > 0) {
					Util.swap(array, j, j + 1);
					swapped = true;
				}
			}
			if(swapped == false) {
				break;
			}
		}
		
	}

}
