package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex; i++) {
			int menor = i;
			for (int j = i + 1; j <= rightIndex; j++) {
				if (array[menor].compareTo(array[j]) > 0) {
					menor = j;
				}
			}
			Util.swap(array, i, menor);
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
		SelectionSort<Integer> ss = new SelectionSort<>();
		Integer[] array = { 5, 3, 6, 85, 63, 21 };
		ss.sort(array);
		System.out.println(array);
		System.out.println(listar(array));

	}
}
