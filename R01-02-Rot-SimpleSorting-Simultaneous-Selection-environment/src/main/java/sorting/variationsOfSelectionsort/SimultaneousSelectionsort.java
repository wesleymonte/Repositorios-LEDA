package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// 5 3 6 85 63 21 9
		int cont = 0;
		for (int i = leftIndex; i < (rightIndex/2); i++) {
			int menor = i;
			int maior = i;
			for(int j = i + 1; j <= rightIndex - cont; j++) {
				if(array[menor].compareTo(array[j]) > 0) {
					menor = j;
				}
				if(array[maior].compareTo(array[j]) < 0) {
					maior = j;
				}
			}
			Util.swap(array, i, menor);
			Util.swap(array, rightIndex - cont, maior);
			cont ++;
		}
	}
	
	public static String listar(Integer[] array) {
		String string = "";
		for (int i : array) {
			string += Integer.toString(i) + " ";
		}
		return string;
	}
	
	public static void main(String[] args) {
		SimultaneousSelectionsort<Integer> sss = new SimultaneousSelectionsort<>();
		Integer[] array = {5,3,6,85,63,21};
		sss.sort(array);
		System.out.println(listar(array));
	}
}
