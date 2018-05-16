package bubbleSort;

import sorting.AbstractSorting;
import util.Util;

public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int gap = rightIndex - leftIndex + 1;
		boolean swapped = false;
		
		while(gap != 1 || swapped) {
			gap = nextGap(gap);
			swapped = false;
			for(int i = leftIndex; i <= rightIndex - gap; i++) {
				if(array[i].compareTo(array[i + 1]) > 0) {
					Util.swap(array, i, i + 1);
					swapped = true;
				}
			}
		}
		
	}
	
	public int nextGap(int gap) {
		gap = (int) (gap / 1.25);
		if(gap < 1) {
			return 1;
		}
		else {
			return gap;
		}
	}
	
}
