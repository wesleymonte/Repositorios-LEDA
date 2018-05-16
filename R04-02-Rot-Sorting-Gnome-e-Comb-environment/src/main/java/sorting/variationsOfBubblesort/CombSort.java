package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(verificaEntrada(array, leftIndex, rightIndex)) {
			int n = rightIndex - leftIndex + 1;
			int gap = n;
			
			boolean swapped = true;
			
			while(gap != 1 || swapped == true) {
				gap = getNextGap(gap);
				
				swapped = false;
				
				for(int i = leftIndex; i <= rightIndex - gap; i++) {
					if(array[i].compareTo(array[i + gap]) > 0) {
						Util.swap(array, i, i + gap);
						swapped = true;
					}
				}
			}
		}
	}
	
	private int getNextGap(int gap) {
		gap = (int) (gap/1.25);
		if(gap < 1) {
			return 1;
		}
		else {
			return gap;
		}
	}
	
	private boolean verificaEntrada(T[] array, int leftIndex, int rightIndex) {
		if(array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length ) {
			return true;
		}
		else {
			return false;
		}
	}
}
