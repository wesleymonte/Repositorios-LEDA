package bubbleSort;

import sorting.AbstractSorting;
import util.Util;

public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int vetor = leftIndex + 1;
		
		while(vetor <= rightIndex) {
			if(array[vetor].compareTo(array[vetor - 1]) < 0) {
				Util.swap(array, vetor - 1, vetor);
				if(vetor == leftIndex + 1) {
					vetor++;
				}
				else {
					vetor--;
				}
			}
			else {
				vetor++;
			}
		}
		
	}
	
	

}
